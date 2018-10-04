import java.util.*;

public class UnitCooler {
    UnitCooler unitOH;

    private double capacityFromCommpressor;
    private double evaporatingTemperatureFromComlect;
    private double condesionTemperatureFromComlect;
    private double airInletTemperatureFromComlect;
    private double deltaAir;
    private double coefficientDeltaTemperature;

    private String name;
    private double capacity;
    private int power;

    private Map<String, Integer> airCoolersCapacitySC2Map = new HashMap<>();
    private Map<String, Integer> airCoolersPowerMap = new HashMap<>();
    private Map<String, Double> airCoolersCapacityMap = new HashMap<>();


    public UnitCooler(UnitOA unitOA) {
        this.capacityFromCommpressor = unitOA.getCapacity();
        this.evaporatingTemperatureFromComlect = unitOA.getEvaporatingTemperature();
        this.condesionTemperatureFromComlect = unitOA.getCondesionTemperature();
        this.airInletTemperatureFromComlect = unitOA.getAirInletTemperature();

        addAirCoolersSC2();
        selectCoefficientDeltaTemperature(evaporatingTemperatureFromComlect, airInletTemperatureFromComlect);
        selectCapacity();

    }

    private UnitCooler(String name, double capacity, int power) {
        this.name = name;
        this.capacity = capacity;
        this.power = power;
    }

    private void addAirCoolersSC2() {
        if (evaporatingTemperatureFromComlect > 1) {
            airCoolersCapacitySC2Map.put("OH201-135S1A-C40", 3234);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E40", 4179);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C40", 6607);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E40", 8239);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C40", 9940);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E40", 12300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C40", 13300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E40", 16636);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E40", 5880);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G40", 6686);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E40", 12000);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G40", 13721);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E40", 18069);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G40", 20547);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E40", 23999);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G40", 27442);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C40", 7400);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E40", 9600);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G40", 10900);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C40", 15100);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E40", 19200);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G40", 22000);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E40", 29100);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G40", 32000);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E40", 37300);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G40", 39200);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C40", 8975);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E40", 12015);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G40", 13955);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C40", 17950);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E40", 24029);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G40", 27910);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E40", 35860);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G40", 42168);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E40", 48078);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G40", 56426);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C55", 2667);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E55", 3612);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C55", 5492);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E55", 7254);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C55", 8318);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E55", 11100);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C55", 11600);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E55", 14617);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E55", 5045);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G55", 5970);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E55", 10378);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G55", 12248);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E55", 15691);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G55", 18457);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E55", 20756);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G55", 24497);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C55", 6200);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E55", 8200);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G55", 9800);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C55", 12700);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E55", 16500);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G55", 19700);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E55", 25400);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G55", 29200);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E55", 33100);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G55", 36500);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C55", 7612);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E55", 10383);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G55", 12408);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C55", 15224);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E55", 20766);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G55", 24815);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E55", 31114);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G55", 37462);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E55", 41651);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G55", 50108);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C70", 2289);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E70", 3184);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C70", 4726);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E70", 6468);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C70", 7174);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E70", 10100);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C70", 10400);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E70", 13005);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E70", 4428);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G70", 5383);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E70", 9154);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G70", 11035);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E70", 13880);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G70", 16696);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E70", 18308);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G70", 22069);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C70", 4800);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E70", 7500);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G70", 8600);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C70", 10700);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E70", 14400);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G70", 17600);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E70", 22000);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G70", 25700);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E70", 28100);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G70", 31500);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C70", 6671);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E70", 9139);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G70", 11144);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C70", 13343);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E70", 18278);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G70", 22288);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E70", 27591);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G70", 33641);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E70", 36905);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G70", 44994);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C100", 1800);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E100", 2700);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C100", 3900);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E100", 5600);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C100", 5900);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E100", 8300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C100", 8000);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E100", 11000);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E100", 3700);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G100", 4800);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E100", 7800);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G100", 10000);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E100", 11800);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G100", 15200);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E100", 15500);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G100", 18700);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C100", 4100);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E100", 6400);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G100", 7400);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C100", 9100);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E100", 12200);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G100", 14900);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E100", 18600);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G100", 21800);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E100", 23800);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G100", 26700);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C100", 5700);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E100", 7800);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G100", 9500);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C100", 10900);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E100", 15300);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G100", 19400);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E100", 23500);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G100", 29300);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E100", 31400);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G100", 39200);

        } else if (evaporatingTemperatureFromComlect > -10) {
            airCoolersCapacitySC2Map.put("OH201-135S1A-C40", 3234);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E40", 4179);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C40", 6607);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E40", 8239);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C40", 9940);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E40", 12300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C40", 13300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E40", 16636);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E40", 5880);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G40", 6686);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E40", 12000);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G40", 13721);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E40", 18069);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G40", 20547);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E40", 23999);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G40", 27442);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C40", 7400);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E40", 9600);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G40", 10900);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C40", 15100);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E40", 19200);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G40", 22000);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E40", 29100);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G40", 32000);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E40", 37300);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G40", 39200);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C40", 8975);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E40", 12015);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G40", 13955);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C40", 17950);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E40", 24029);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G40", 27910);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E40", 35860);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G40", 42168);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E40", 48078);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G40", 56426);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C55", 2667);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E55", 3612);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C55", 5492);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E55", 7254);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C55", 8318);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E55", 11100);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C55", 11600);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E55", 14617);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E55", 5045);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G55", 5970);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E55", 10378);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G55", 12248);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E55", 15691);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G55", 18457);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E55", 20756);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G55", 24497);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C55", 6200);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E55", 8200);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G55", 9800);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C55", 12700);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E55", 16500);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G55", 19700);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E55", 25400);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G55", 29200);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E55", 33100);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G55", 36500);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C55", 7612);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E55", 10383);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G55", 12408);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C55", 15224);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E55", 20766);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G55", 24815);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E55", 31114);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G55", 37462);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E55", 41651);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G55", 50108);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C70", 2289);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E70", 3184);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C70", 4726);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E70", 6468);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C70", 7174);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E70", 10100);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C70", 10400);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E70", 13005);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E70", 4428);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G70", 5383);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E70", 9154);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G70", 11035);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E70", 13880);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G70", 16696);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E70", 18308);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G70", 22069);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C70", 4800);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E70", 7500);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G70", 8600);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C70", 10700);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E70", 14400);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G70", 17600);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E70", 22000);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G70", 25700);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E70", 28100);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G70", 31500);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C70", 6671);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E70", 9139);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G70", 11144);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C70", 13343);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E70", 18278);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G70", 22288);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E70", 27591);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G70", 33641);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E70", 36905);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G70", 44994);
        } else {
            airCoolersCapacitySC2Map.put("OH201-135S1A-C70", 2289);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E70", 3184);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C70", 4726);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E70", 6468);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C70", 7174);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E70", 10100);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C70", 10400);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E70", 13005);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E70", 4428);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G70", 5383);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E70", 9154);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G70", 11035);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E70", 13880);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G70", 16696);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E70", 18308);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G70", 22069);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C70", 4800);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E70", 7500);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G70", 8600);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C70", 10700);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E70", 14400);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G70", 17600);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E70", 22000);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G70", 25700);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E70", 28100);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G70", 31500);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C70", 6671);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E70", 9139);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G70", 11144);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C70", 13343);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E70", 18278);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G70", 22288);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E70", 27591);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G70", 33641);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E70", 36905);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G70", 44994);
            airCoolersCapacitySC2Map.put("OH201-135S1A-C100", 1800);
            airCoolersCapacitySC2Map.put("OH201-135S1A-E100", 2700);
            airCoolersCapacitySC2Map.put("OH201-235S1A-C100", 3900);
            airCoolersCapacitySC2Map.put("OH201-235S1A-E100", 5600);
            airCoolersCapacitySC2Map.put("OH201-335S1A-C100", 5900);
            airCoolersCapacitySC2Map.put("OH201-335S1A-E100", 8300);
            airCoolersCapacitySC2Map.put("OH201-435S1A-C100", 8000);
            airCoolersCapacitySC2Map.put("OH201-435S1A-E100", 11000);
            airCoolersCapacitySC2Map.put("OH201-140S1A-E100", 3700);
            airCoolersCapacitySC2Map.put("OH201-140S1A-G100", 4800);
            airCoolersCapacitySC2Map.put("OH201-240S1A-E100", 7800);
            airCoolersCapacitySC2Map.put("OH201-240S1A-G100", 10000);
            airCoolersCapacitySC2Map.put("OH201-340S1A-E100", 11800);
            airCoolersCapacitySC2Map.put("OH201-340S1A-G100", 15200);
            airCoolersCapacitySC2Map.put("OH201-440S1A-E100", 15500);
            airCoolersCapacitySC2Map.put("OH201-440S1A-G100", 18700);
            airCoolersCapacitySC2Map.put("OH201-145S1A-C100", 4100);
            airCoolersCapacitySC2Map.put("OH201-145S1A-E100", 6400);
            airCoolersCapacitySC2Map.put("OH201-145S1A-G100", 7400);
            airCoolersCapacitySC2Map.put("OH201-245S1A-C100", 9100);
            airCoolersCapacitySC2Map.put("OH201-245S1A-E100", 12200);
            airCoolersCapacitySC2Map.put("OH201-245S1A-G100", 14900);
            airCoolersCapacitySC2Map.put("OH201-345S1A-E100", 18600);
            airCoolersCapacitySC2Map.put("OH201-345S1A-G100", 21800);
            airCoolersCapacitySC2Map.put("OH201-445S1A-E100", 23800);
            airCoolersCapacitySC2Map.put("OH201-445S1A-G100", 26700);
            airCoolersCapacitySC2Map.put("OH201-150S1A-C100", 5700);
            airCoolersCapacitySC2Map.put("OH201-150S1A-E100", 7800);
            airCoolersCapacitySC2Map.put("OH201-150S1A-G100", 9500);
            airCoolersCapacitySC2Map.put("OH201-250S1A-C100", 10900);
            airCoolersCapacitySC2Map.put("OH201-250S1A-E100", 15300);
            airCoolersCapacitySC2Map.put("OH201-250S1A-G100", 19400);
            airCoolersCapacitySC2Map.put("OH201-350S1A-E100", 23500);
            airCoolersCapacitySC2Map.put("OH201-350S1A-G100", 29300);
            airCoolersCapacitySC2Map.put("OH201-450S1A-E100", 31400);
            airCoolersCapacitySC2Map.put("OH201-450S1A-G100", 39200);
        }
        airCoolersPowerMap.put("OH201-135S1A-C40", 1536);
        airCoolersPowerMap.put("OH201-135S1A-E40", 1920);
        airCoolersPowerMap.put("OH201-235S1A-C40", 3520);
        airCoolersPowerMap.put("OH201-235S1A-E40", 4224);
        airCoolersPowerMap.put("OH201-335S1A-C40", 5120);
        airCoolersPowerMap.put("OH201-335S1A-E40", 6144);
        airCoolersPowerMap.put("OH201-435S1A-C40", 6720);
        airCoolersPowerMap.put("OH201-435S1A-E40", 8064);
        airCoolersPowerMap.put("OH201-140S1A-E40", 3584);
        airCoolersPowerMap.put("OH201-140S1A-G40", 4480);
        airCoolersPowerMap.put("OH201-240S1A-E40", 7488);
        airCoolersPowerMap.put("OH201-240S1A-G40", 9152);
        airCoolersPowerMap.put("OH201-340S1A-E40", 9728);
        airCoolersPowerMap.put("OH201-340S1A-G40", 13376);
        airCoolersPowerMap.put("OH201-440S1A-E40", 14400);
        airCoolersPowerMap.put("OH201-440S1A-G40", 17600);
        airCoolersPowerMap.put("OH201-145S1A-C40", 2880);
        airCoolersPowerMap.put("OH201-145S1A-E40", 8640);
        airCoolersPowerMap.put("OH201-145S1A-G40", 5280);
        airCoolersPowerMap.put("OH201-245S1A-C40", 6272);
        airCoolersPowerMap.put("OH201-245S1A-E40", 8064);
        airCoolersPowerMap.put("OH201-245S1A-G40", 9856);
        airCoolersPowerMap.put("OH201-345S1A-E40", 12096);
        airCoolersPowerMap.put("OH201-345S1A-G40", 14784);
        airCoolersPowerMap.put("OH201-445S1A-E40", 15552);
        airCoolersPowerMap.put("OH201-445S1A-G40", 20736);
        airCoolersPowerMap.put("OH201-150S1A-C40", 4256);
        airCoolersPowerMap.put("OH201-150S1A-E40", 5472);
        airCoolersPowerMap.put("OH201-150S1A-G40", 6688);
        airCoolersPowerMap.put("OH201-250S1A-C40", 8064);
        airCoolersPowerMap.put("OH201-250S1A-E40", 11520);
        airCoolersPowerMap.put("OH201-250S1A-G40", 13824);
        airCoolersPowerMap.put("OH201-350S1A-E40", 17280);
        airCoolersPowerMap.put("OH201-350S1A-G40", 22464);
        airCoolersPowerMap.put("OH201-450S1A-E40", 24640);
        airCoolersPowerMap.put("OH201-450S1A-G40", 31360);
        airCoolersPowerMap.put("OH201-135S1A-C55", 1536);
        airCoolersPowerMap.put("OH201-135S1A-E55", 1920);
        airCoolersPowerMap.put("OH201-235S1A-C55", 3520);
        airCoolersPowerMap.put("OH201-235S1A-E55", 4224);
        airCoolersPowerMap.put("OH201-335S1A-C55", 5120);
        airCoolersPowerMap.put("OH201-335S1A-E55", 6144);
        airCoolersPowerMap.put("OH201-435S1A-C55", 6720);
        airCoolersPowerMap.put("OH201-435S1A-E55", 8064);
        airCoolersPowerMap.put("OH201-140S1A-E55", 3584);
        airCoolersPowerMap.put("OH201-140S1A-G55", 4480);
        airCoolersPowerMap.put("OH201-240S1A-E55", 7488);
        airCoolersPowerMap.put("OH201-240S1A-G55", 9152);
        airCoolersPowerMap.put("OH201-340S1A-E55", 9728);
        airCoolersPowerMap.put("OH201-340S1A-G55", 13376);
        airCoolersPowerMap.put("OH201-440S1A-E55", 14400);
        airCoolersPowerMap.put("OH201-440S1A-G55", 17600);
        airCoolersPowerMap.put("OH201-145S1A-C55", 2880);
        airCoolersPowerMap.put("OH201-145S1A-E55", 4320);
        airCoolersPowerMap.put("OH201-145S1A-G55", 5280);
        airCoolersPowerMap.put("OH201-245S1A-C55", 6272);
        airCoolersPowerMap.put("OH201-245S1A-E55", 8064);
        airCoolersPowerMap.put("OH201-245S1A-G55", 9856);
        airCoolersPowerMap.put("OH201-345S1A-E55", 12096);
        airCoolersPowerMap.put("OH201-345S1A-G55", 14784);
        airCoolersPowerMap.put("OH201-445S1A-E55", 15552);
        airCoolersPowerMap.put("OH201-445S1A-G55", 20736);
        airCoolersPowerMap.put("OH201-150S1A-C55", 4256);
        airCoolersPowerMap.put("OH201-150S1A-E55", 5472);
        airCoolersPowerMap.put("OH201-150S1A-G55", 6688);
        airCoolersPowerMap.put("OH201-250S1A-C55", 8064);
        airCoolersPowerMap.put("OH201-250S1A-E55", 11520);
        airCoolersPowerMap.put("OH201-250S1A-G55", 13824);
        airCoolersPowerMap.put("OH201-350S1A-E55", 17280);
        airCoolersPowerMap.put("OH201-350S1A-G55", 22464);
        airCoolersPowerMap.put("OH201-450S1A-E55", 24640);
        airCoolersPowerMap.put("OH201-450S1A-G55", 31360);
        airCoolersPowerMap.put("OH201-135S1A-C70", 1536);
        airCoolersPowerMap.put("OH201-135S1A-E70", 1920);
        airCoolersPowerMap.put("OH201-235S1A-C70", 3520);
        airCoolersPowerMap.put("OH201-235S1A-E70", 4224);
        airCoolersPowerMap.put("OH201-335S1A-C70", 5120);
        airCoolersPowerMap.put("OH201-335S1A-E70", 6144);
        airCoolersPowerMap.put("OH201-435S1A-C70", 6720);
        airCoolersPowerMap.put("OH201-435S1A-E70", 8064);
        airCoolersPowerMap.put("OH201-140S1A-E70", 3584);
        airCoolersPowerMap.put("OH201-140S1A-G70", 4480);
        airCoolersPowerMap.put("OH201-240S1A-E70", 7488);
        airCoolersPowerMap.put("OH201-240S1A-G70", 9152);
        airCoolersPowerMap.put("OH201-340S1A-E70", 9728);
        airCoolersPowerMap.put("OH201-340S1A-G70", 13376);
        airCoolersPowerMap.put("OH201-440S1A-E70", 14400);
        airCoolersPowerMap.put("OH201-440S1A-G70", 17600);
        airCoolersPowerMap.put("OH201-145S1A-C70", 2880);
        airCoolersPowerMap.put("OH201-145S1A-E70", 4320);
        airCoolersPowerMap.put("OH201-145S1A-G70", 5280);
        airCoolersPowerMap.put("OH201-245S1A-C70", 6272);
        airCoolersPowerMap.put("OH201-245S1A-E70", 8064);
        airCoolersPowerMap.put("OH201-245S1A-G70", 9856);
        airCoolersPowerMap.put("OH201-345S1A-E70", 12096);
        airCoolersPowerMap.put("OH201-345S1A-G70", 14784);
        airCoolersPowerMap.put("OH201-445S1A-E70", 15552);
        airCoolersPowerMap.put("OH201-445S1A-G70", 20736);
        airCoolersPowerMap.put("OH201-150S1A-C70", 4256);
        airCoolersPowerMap.put("OH201-150S1A-E70", 5472);
        airCoolersPowerMap.put("OH201-150S1A-G70", 6688);
        airCoolersPowerMap.put("OH201-250S1A-C70", 8064);
        airCoolersPowerMap.put("OH201-250S1A-E70", 11520);
        airCoolersPowerMap.put("OH201-250S1A-G70", 13824);
        airCoolersPowerMap.put("OH201-350S1A-E70", 17280);
        airCoolersPowerMap.put("OH201-350S1A-G70", 22464);
        airCoolersPowerMap.put("OH201-450S1A-E70", 24640);
        airCoolersPowerMap.put("OH201-450S1A-G70", 31360);
        airCoolersPowerMap.put("OH201-135S1A-C100", 1536);
        airCoolersPowerMap.put("OH201-135S1A-E100", 1920);
        airCoolersPowerMap.put("OH201-235S1A-C100", 3520);
        airCoolersPowerMap.put("OH201-235S1A-E100", 4224);
        airCoolersPowerMap.put("OH201-335S1A-C100", 5120);
        airCoolersPowerMap.put("OH201-335S1A-E100", 6144);
        airCoolersPowerMap.put("OH201-435S1A-C100", 6720);
        airCoolersPowerMap.put("OH201-435S1A-E100", 8064);
        airCoolersPowerMap.put("OH201-140S1A-E100", 3584);
        airCoolersPowerMap.put("OH201-140S1A-G100", 4480);
        airCoolersPowerMap.put("OH201-240S1A-E100", 7488);
        airCoolersPowerMap.put("OH201-240S1A-G100", 9152);
        airCoolersPowerMap.put("OH201-340S1A-E100", 9728);
        airCoolersPowerMap.put("OH201-340S1A-G100", 13376);
        airCoolersPowerMap.put("OH201-440S1A-E100", 14400);
        airCoolersPowerMap.put("OH201-440S1A-G100", 17600);
        airCoolersPowerMap.put("OH201-145S1A-C100", 2880);
        airCoolersPowerMap.put("OH201-145S1A-E100", 4320);
        airCoolersPowerMap.put("OH201-145S1A-G100", 5280);
        airCoolersPowerMap.put("OH201-245S1A-C100", 6272);
        airCoolersPowerMap.put("OH201-245S1A-E100", 8064);
        airCoolersPowerMap.put("OH201-245S1A-G100", 9856);
        airCoolersPowerMap.put("OH201-345S1A-E100", 12096);
        airCoolersPowerMap.put("OH201-345S1A-G100", 14784);
        airCoolersPowerMap.put("OH201-445S1A-E100", 15552);
        airCoolersPowerMap.put("OH201-445S1A-G100", 20736);
        airCoolersPowerMap.put("OH201-150S1A-C100", 4256);
        airCoolersPowerMap.put("OH201-150S1A-E100", 5472);
        airCoolersPowerMap.put("OH201-150S1A-G100", 6688);
        airCoolersPowerMap.put("OH201-250S1A-C100", 8064);
        airCoolersPowerMap.put("OH201-250S1A-E100", 11520);
        airCoolersPowerMap.put("OH201-250S1A-G100", 13824);
        airCoolersPowerMap.put("OH201-350S1A-E100", 17280);
        airCoolersPowerMap.put("OH201-350S1A-G100", 22464);
        airCoolersPowerMap.put("OH201-450S1A-E100", 24640);
        airCoolersPowerMap.put("OH201-450S1A-G100", 31360);
    }

    private void selectCoefficientDeltaTemperature(double evaporatingTemperature, double airInletTemperature) {
        deltaAir = airInletTemperature - evaporatingTemperature;
        deltaAir = Math.abs(deltaAir);
        if (deltaAir > 9) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 1.087;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 1.099;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 1.220;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 1.159;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 1.190;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 1.220;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 1.250;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 1.293;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 1.337;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 1.380;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 1.424;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 1.467;
            }
        }
        if (deltaAir > 8 && deltaAir <= 9) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.978;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.989;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 1.016;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 1.043;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 1.071;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 1.098;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 1.125;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 1.164;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 1.203;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 1.243;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 1.282;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 1.321;
            }
        }
        if (deltaAir > 7 && deltaAir <= 8) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.870;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.879;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 0.903;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 0.928;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 0.952;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 0.976;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 1.0;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 1.035;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 1.070;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 1.104;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 1.139;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 1.174;
            }
        }
        if (deltaAir > 6 && deltaAir <= 7) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.761;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.769;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 0.790;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 0.812;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 0.833;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 0.854;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 0.875;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 0.905;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 0.936;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 0.966;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 0.997;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 1.027;
            }
        }
        if (deltaAir > 5 && deltaAir <= 6) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.652;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.659;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 0.678;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 0.696;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 0.714;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 0.732;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 0.750;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 0.776;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 0.802;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 0.828;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 0.854;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 0.880;
            }
        }
        if (deltaAir > 4 && deltaAir <= 5) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.543;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.550;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 0.565;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 0.580;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 0.595;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 0.610;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 0.625;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 0.647;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 0.669;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 0.690;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 0.712;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 0.734;
            }
        }
        if (deltaAir == 4) {
            if (airInletTemperature < -26) {
                coefficientDeltaTemperature = 0.435;
            }
            if (airInletTemperature > -26 && airInletTemperature < -24) {
                coefficientDeltaTemperature = 0.440;
            }
            if (airInletTemperature > -25 && airInletTemperature < -19) {
                coefficientDeltaTemperature = 0.452;
            }
            if (airInletTemperature > -20 && airInletTemperature < -14) {
                coefficientDeltaTemperature = 0.464;
            }
            if (airInletTemperature > -15 && airInletTemperature < -9) {
                coefficientDeltaTemperature = 0.476;
            }
            if (airInletTemperature > -10 && airInletTemperature < -4) {
                coefficientDeltaTemperature = 0.488;
            }
            if (airInletTemperature > -5 && airInletTemperature < 1) {
                coefficientDeltaTemperature = 0.5;
            }
            if (airInletTemperature > 0 && airInletTemperature <= 1) {
                coefficientDeltaTemperature = 0.517;
            }
            if (airInletTemperature > 1 && airInletTemperature <= 2) {
                coefficientDeltaTemperature = 0.535;
            }
            if (airInletTemperature > 2 && airInletTemperature <= 3) {
                coefficientDeltaTemperature = 0.552;
            }
            if (airInletTemperature > 3 && airInletTemperature <= 4) {
                coefficientDeltaTemperature = 0.570;
            }
            if (airInletTemperature > 4) {
                coefficientDeltaTemperature = 0.587;
            }
        }
    }

    private void selectCapacity() {
        for (Map.Entry<String, Integer> entry : airCoolersCapacitySC2Map.entrySet()) {
            double capacityVO = entry.getValue() * coefficientDeltaTemperature * 0.97;
            airCoolersCapacityMap.put(entry.getKey(), capacityVO);
        }

        ArrayList<Double> list = new ArrayList();
        for (Object i : sortedMapToValue(airCoolersCapacityMap)) {
            char[] chars = i.toString().toCharArray();
            ArrayList arrayList = new ArrayList();
            for (int j = chars.length - 1; j > -1; j--) {
                if (chars[j] != '=') arrayList.add(0, chars[j]);
                else break;
            }
            list.add(Double.parseDouble(getStringRepresentation(arrayList)));
        }
        for (int k = 0; k < list.size(); k++) {
            double capacityVO = list.get(k);
            if (capacityVO >= capacityFromCommpressor) {
                capacity = list.get(k);
                break;
            }
        }
        for (Map.Entry<String, Double> entry : airCoolersCapacityMap.entrySet()) {
            if (entry.getValue() == capacity) {
                name = entry.getKey();
                for (Map.Entry<String, Integer> entry1 : airCoolersPowerMap.entrySet()) {
                    if (entry1.getKey() == name) {
                        if (airInletTemperatureFromComlect < 5) power = entry1.getValue();
                        else power = 0;
                    }
                }
                unitOH = new UnitCooler(name, capacity, power);
            }
        }
    }

    public ArrayList sortedMapToValue(Map<String, Double> mapQ) {
        ArrayList listCapacity = new ArrayList(mapQ.entrySet());
        Collections.sort(listCapacity, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return listCapacity;
    }

    private String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
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

    public UnitCooler getUnitOH() {
        return unitOH;
    }

}
