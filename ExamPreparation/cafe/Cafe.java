package ExamPreparation.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (this.employees.size()<this.capacity){
            this.employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }
    public Employee getOldestEmployee(){
       return this.employees.stream().sorted((l,r)->Integer.compare(r.getAge(), l.getAge())).limit(1)
                .collect(Collectors.toList()).get(0);
    }
    public Employee getEmployee(String name){
       return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:",this.name));
        for (Employee employee:this.employees){
            sb.append(System.lineSeparator());
            sb.append(employee);
        }
        return sb.toString().trim();
    }
}
