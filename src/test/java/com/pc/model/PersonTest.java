package com.pc.model;

import java.io.*;

/**
 * Created by PC on 2017/8/8.
 */
public class PersonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 101, "man");
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }
}