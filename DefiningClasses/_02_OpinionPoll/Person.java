package Classes._02_OpinionPoll;

import java.util.Map;
import java.util.TreeMap;

public class Person {

    private String name;
    private int age;

    private Map<String, Integer> data;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.data = new TreeMap<>();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}






