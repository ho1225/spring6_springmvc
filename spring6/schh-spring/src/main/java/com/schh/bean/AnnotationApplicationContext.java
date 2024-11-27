package com.schh.bean;

import com.schh.anno.Bean;
import com.schh.anno.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    //create map, put bean inside
    private Map<Class, Object> beanFactory =  new HashMap<>();
    private static String rootPath;


    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // set package scan rules (where have @bean, then implement reflection to make this class instance
    // create constructor with argument and transfer package path
    public AnnotationApplicationContext(String basePackage) {
        String packagePath = basePackage.replaceAll("\\.", "\\\\");

        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);

            while(urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);

                //get the front part of filePath
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                //package scan
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Dependency injection
        loadDi();
    }


    //package scan function
    private void loadBean(File file) throws Exception {
        // 1 identify if it is folder
        if(file.isDirectory()){
        // 2 get all content in folder
            File[] childrenFiles = file.listFiles();
        // 3 identify if folder is empty, if yes then return
            if(childrenFiles == null || childrenFiles.length ==0){
                return;
            }
        // 4 if folder no empty, loop it
            for(File child: childrenFiles){
                // 4.1 get every file object in loop to keep identifying, if it is still folder, recursion
                    if(child.isDirectory()){
                        loadBean(child);
                    }else{
                        // 4.2 if file object in loop is file but not folder
                        // 4.3 get package path and class name- get string
                        String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

                        // 4.4 identify if current folder is .class
                        if(pathWithClass.contains(".class")) {
                            // 4.5 if .class, make "\" in path to ".", and delete ".class"
                            // e.g com.schh.service.UserSerice.Impl
                            String allName = pathWithClass.replaceAll("\\\\", ".")
                                    .replace(".class", "");

                            // 4.6 identify if there is any @Bean, if yes, Instantiation
                            //4.6.1 get class
                            Class<?> clazz = Class.forName(allName);
                            //4.6.2 if not interface then Instantiation
                            if(!clazz.isInterface()){
                                //4.6.3 identify if there is any @Bean
                                Bean annotation = clazz.getAnnotation(Bean.class);
                                if(annotation != null){
                                    //4.6.4 instantiation
                                    Object instance = clazz.getConstructor().newInstance();
                                    // 4.7 after Instantiation, put them in map (beanFactory)
                                    // 4.7.1 identify current class has interface, make interface class as map Key
                                    if(clazz.getInterfaces().length>0){
                                        beanFactory.put(clazz.getInterfaces()[0], instance);
                                    } else {
                                        beanFactory.put(clazz, instance);
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }

    // Dependency injection
    private void loadDi() {
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class, Object> entry : entries){
            Object obj = entry.getValue();

            Class<?> clazz = obj.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();

            for(Field field: declaredFields){
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null){
                    field.setAccessible(true);
                    try {
                        field.set(obj, beanFactory.get(field.getType())); //find object by geting type
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationApplicationContext("com.schh");
//        context.getBean();
//
//    }
}
