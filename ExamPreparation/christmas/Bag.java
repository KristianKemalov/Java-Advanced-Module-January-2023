package ExamPreparation.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.count() >= this.getCapacity()) {
            return;
        }
        this.data.add(present);

    }

    public boolean remove(String name) {

        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
        //this.data.removeIf(p->p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .sorted((l, r) -> Double.compare(r.getWeight(), l.getWeight()))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);

//        Present heaviest=this.data.get(0);
//        for (Present present:data){
//            if (present.getWeight()>heaviest.getWeight()){
//                heaviest=present;
//            }
//        }
//        return heaviest;
    }

    public Present getPresent(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;

    }

    public String report() {
        String presentString = this.data.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));
        return String.format("%s color of bag:\n%s", this.color, presentString);
    }
}