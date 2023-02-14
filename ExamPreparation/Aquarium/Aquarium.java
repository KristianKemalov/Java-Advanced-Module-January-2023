import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        if (!this.fishInPool.contains(fish) && this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        this.fishInPool.removeIf(f -> f.getName().equals(name));
        return true;
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", this.name,this.size));
        for (Fish fish : this.fishInPool) {
            sb.append(fish).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
