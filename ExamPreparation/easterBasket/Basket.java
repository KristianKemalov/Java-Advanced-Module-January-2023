package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;

    public String getMaterial() {
        return material;
    }

    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }


    public Egg getStrongestEgg() {
        int max = 0;
        Egg strongest = null;


        for (Egg egg : this.data) {
            if (egg.getStrength() > max) {
                max = egg.getStrength();
                strongest = egg;
            }
        }
        return strongest;
    }
    public Egg getEgg(String color){
        for (Egg egg:this.data){
            if (egg.getColor().equals(color)){
                return egg;
            }
        }
        return null;
    }
    public int getCount(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append(this.material).append(" basket contains:").append(System.lineSeparator());
        for (Egg egg:this.data){
            sb.append(egg).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
