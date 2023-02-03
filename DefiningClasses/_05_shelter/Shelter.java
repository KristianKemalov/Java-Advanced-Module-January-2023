package shelter;


import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;

    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;

        this.data = new ArrayList<>();

    }

    public void add(Animal animal) {
        if (this.data.size()  < this.capacity) {
            this.data.add(animal);

        }
    }

    public boolean remove(String name) {
        for (Animal animal:data){
            if (animal.getName().equals(name)){
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal :this.data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        int max = 0;
        Animal oldest = null;
        for (Animal animal : this.data) {
            if (animal.getAge() > max) {
                max = animal.getAge();
                oldest = animal;
            }
        }
        return oldest;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(animal -> sb.append(String.format("%s %s", animal.getName(), animal.getCaretaker())).append(System.lineSeparator()));
        return sb.toString();
    }

}
