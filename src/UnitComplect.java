import java.util.ArrayList;

public class UnitComplect {
    private UnitOA unitOA;
    private UnitCooler unitOH;
    private UnitEbo unitEbo;
    private Unit unit;

    private double capacity;
    private double evaporatingTemperature;
    private ArrayList<Unit> units = new ArrayList<>();

    public UnitComplect() {
    }

    private double condesionTemperature;
    private double airInletTemperature;



    public UnitComplect(double capacity, double evaporatingTemperature, double condesionTemperature, double airInletTemperature) {
        this.capacity = capacity;
        this.evaporatingTemperature = evaporatingTemperature;
        this.condesionTemperature = condesionTemperature;
        this.airInletTemperature = airInletTemperature;
        Compressor compressor = new Compressor(this);
        unitOA = new UnitOA(compressor);
        ArrayList<UnitOA> list = unitOA.getListOA();

        for (int i=0;i<list.size();i++){
            Unit unitSpace = new Unit("Комплект #"+(i+1));
            units.add(unitSpace);
            Unit unitA = new Unit(list.get(i).getName(),list.get(i).getCapacity(),list.get(i).getPower());
            units.add(unitA);
            UnitCooler unitOH =new UnitCooler(list.get(i));
            Unit unitH = new Unit(unitOH.getName(),unitOH.getCapacity(),unitOH.getPower());
            units.add(unitH);
            UnitEbo unitEbo = new UnitEbo(unitOH);
            Unit unitE = new Unit(unitEbo.getName(),0,0);
            units.add(unitE);

        }
    }

    public double getCapacity() {
        return capacity;
    }

    public double getEvaporatingTemperature() {
        return evaporatingTemperature;
    }

    public double getCondesionTemperature() {
        return condesionTemperature;
    }

    public double getAirInletTemperature() {
        return airInletTemperature;
    }

    public UnitOA getUnitOA() {
        return unitOA;
    }

    public UnitCooler getUnitOH() {
        return unitOH;
    }

    public UnitEbo getUnitEbo() {
        return unitEbo;
    }

    public Unit getUnit() {
        return unit;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }
}
