public class UnitEbo {
    private String name;
    private int capacity = 0;
    private int power = 0;

    public UnitEbo(UnitCooler unitCooler) {

        if ((double) (unitCooler.getPower() / 660) < 17) {
            name = "EBO-13-17-EW941";
        } else {
            if ((double) (unitCooler.getPower() / 660) < 32) {
                name = "EBO-13-32-EW941";
            } else {
                if ((double) (unitCooler.getPower() / 660) < 50) {
                    name = "EBO-13-50-EW941";
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPower() {
        return power;
    }
}
