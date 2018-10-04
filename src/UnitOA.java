import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnitOA {
    private String name;
    private int capacity;
    private int power;
    private double evaporatingTemperature;
    private double condesionTemperature;
    private double airInletTemperature;

    Map<String, String> mapOAname = new HashMap<>();
    ArrayList<UnitOA> listOA = new ArrayList<>();

    public UnitOA(Compressor compressor) {
        addNameTo(mapOAname);
        evaporatingTemperature = compressor.getEvaporatingTemperatureFromComlect();
        condesionTemperature = compressor.getCondesionTemperatureFromComlect();
        airInletTemperature = compressor.getAirInletTemperatureFromComlect();
        for (int i = 0; i < compressor.getCompressorsList().size(); i++) {

            for (Map.Entry<String, String> stringEntry : mapOAname.entrySet()) {
                if (stringEntry.getValue() == compressor.getCompressorsList().get(i).getName()) {
                    name = stringEntry.getKey();
                    capacity = compressor.getCompressorsList().get(i).getCapacity();
                    power = compressor.getCompressorsList().get(i).getPower();
                    listOA.add(new UnitOA(name, capacity, power, evaporatingTemperature, condesionTemperature, airInletTemperature));
                }
            }
        }
    }

    public UnitOA(String name, int capacity, int power, double evaporatingTemperature, double condesionTemperature, double airInletTemperature) {
        this.name = name;
        this.capacity = capacity;
        this.power = power;
        this.evaporatingTemperature = evaporatingTemperature;
        this.condesionTemperature = condesionTemperature;
        this.airInletTemperature = airInletTemperature;
    }

    private void addNameTo(Map mapOAname) {
        mapOAname.put("OA151-MS-E46", "2GES-2Y");
        mapOAname.put("OA151-MS-E54", "2FES-3Y");
        mapOAname.put("OA151-MS-E82", "2DES-3Y");
        mapOAname.put("OA151-MS-E112", "4FES-5Y");
        mapOAname.put("OA151-MS-E143", "4EES-6Y");
        mapOAname.put("OA151-MS-E164", "4DES-7Y");
        mapOAname.put("OA151-MS-E206", "4CES-9Y");
        mapOAname.put("OA151-MS-E250", "4TES-12Y");
        mapOAname.put("OA151-MS-E299", "4PES-15Y");
        mapOAname.put("OA151-MS-E341", "4NES-20Y");
        mapOAname.put("OA151-MS-E454", "4HE-25Y");

        mapOAname.put("OA151-LS-E19", "2GES-2Y");
        mapOAname.put("OA151-LS-E36", "2DES-2Y");
        mapOAname.put("OA151-LS-E43", "2CES-3Y");
        mapOAname.put("OA151-LS-E59", "4EES-4Y");
        mapOAname.put("OA151-LS-E68", "4DES-5Y");
        mapOAname.put("OA151-LS-E77", "4CES-6Y");
        mapOAname.put("OA151-LS-E97", "4TES-9Y");
        mapOAname.put("OA151-LS-E121", "4NES-14Y");
        mapOAname.put("OA151-LS-E176", "4HE-18Y");
        mapOAname.put("OA151-LS-E268", "4FE-28Y");
        mapOAname.put("OA151-LS-E316", "6GE-34Y");
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

    public ArrayList<UnitOA> getListOA() {
        return listOA;
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
}
