package com.itcm.example06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Example01 {
    @Person(name = "张三",sex =SexEnum.FEMALE,age=20)
    private Human human1;
    @Person(name = "李四  ",sex =SexEnum.MALE)
    private Human human2;
    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Example01 example01=new Example01();
        System.out.println(example01.human1);
        System.out.println(example01.human2);
        initField(example01);
        System.out.println(example01.human1);
        System.out.println(example01.human2);

    }

    private static void initField(Example01 example01) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class Clazz  = example01.getClass();
        Field field1 = Clazz.getDeclaredField("human1");
        Field field2 = Clazz.getDeclaredField("human2");
        Person person1=field1.getDeclaredAnnotation(Person.class);
        Person person2=field2 .getDeclaredAnnotation(Person.class);
        Class clz = field1.getType();
        Constructor constructor = clz.getConstructor();
        Human human1=(Human)constructor.newInstance();
        Human human2=(Human)constructor.newInstance ();
        human1.setName(person1.name());
        human1.setSex(person1.sex());
        human1.setAge(person1.age());
        human2.setName(person2.name());
        human2.setAge(person2.age());
        human2.setSex(person2.sex());
        field1.set(example01,human1);
        field2.set(example01,human2);
    }
}
