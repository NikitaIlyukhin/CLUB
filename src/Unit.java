/**
 * Created by Никита on 30.05.2018.
 */
public class Unit {
    private String name;
    private double capacity;
    private int power;

    public Unit(String name, double capacity, int power) {
        this.name = name;
        this.capacity = capacity;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getPower() {
        return power;
    }

    public Unit(String name) {
        this.name = name;
    }
}
