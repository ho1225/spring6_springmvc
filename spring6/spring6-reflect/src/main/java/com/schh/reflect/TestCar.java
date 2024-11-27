package com.schh.reflect;

import org.junit.jupiter.api.Test;

public class TestCar {

    // 1. 3method to get class
    @Test
    public void test01() throws Exception {
        //1 class name.class
        Class clazz1 = Car.class;
        //2 object.getClass()
        Class clazz2 = new Car().getClass();
        //3 Class.forName(whole path)
        Class clazz3 = Class.forName("com.schh.reflect.Car");

        //instantiation
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    // 2. get constructor


    // 3. get properties

    // 4. get method
}
