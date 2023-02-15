package ExamPreparation.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();

    }
    public void add(Rabbit rabbit){
        if (this.data.size()<this.capacity){
            this.data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        this.data.removeIf(r->r.getName().equals(name));
        return true;
//        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
//        return this.data.remove(rabbit);
    }
    public void removeSpecies(String species){
            this.data.removeIf(r -> r.getSpecies().equals(species));
    }
    public Rabbit sellRabbit(String name){
            for (Rabbit rabbit:this.data){
                if (rabbit.getName().equals(name)){
                    rabbit.setAvailable(false);
                    return rabbit;
                }
            }

        return null;
//        Rabbit rabbit1 = this.data.stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().orElseThrow();
//        rabbit1.setAvailable(false);
//        return rabbit1;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> toReturn=new ArrayList<>();
        for (Rabbit rabbit:this.data){
            if (rabbit.getSpecies().equals(species)){
                toReturn.add(rabbit);
            }
        }
        return toReturn;
       // return this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Rabbits available at %s:",this.name));
        for (Rabbit rabbit:this.data){
            if (rabbit.isAvailable()){
                sb.append(System.lineSeparator());
                sb.append(rabbit);
            }
        }
        return sb.toString().trim();

    }
}
