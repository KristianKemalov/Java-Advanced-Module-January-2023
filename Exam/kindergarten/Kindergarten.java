package Exam.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry=new ArrayList<>();
    }
    public boolean addChild(Child child){
        if (this.registry.size()<this.capacity){
            this.registry.add(child);
            return true;
        }else {
            return false;
        }

    }

    public boolean removeChild(String firstName){
       return this.registry.removeIf(child -> child.getFirstName().equals(firstName));
    }
    public int getChildrenCount(){
        return this.registry.size();
    }
    public Child getChild(String firstName){
        return this.registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().orElse(null);
    }
    public String registryReport(){

        Comparator<Child> compareByAge = Comparator.comparing( Child::getAge );
        Comparator<Child> compareByLastName = Comparator.comparing( Child::getLastName );
        Comparator<Child> compareByFirstName = Comparator.comparing( Child::getFirstName );
        Comparator<Child> compare = Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getFirstName);

        List<Child> sorted = this.registry.stream().sorted(compare).collect(Collectors.toList());


        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Registered children in %s:",this.name));
        sorted.forEach(c-> sb.append(System.lineSeparator()).append("--").append(System.lineSeparator()).append(c));
        return sb.toString().trim();
    }
}
