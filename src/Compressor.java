import java.util.*;

public class Compressor {

    private double capacityFromComlect;
    private double evaporatingTemperatureFromComlect;
    private double condesionTemperatureFromComlect;
    private double airInletTemperatureFromComlect;

    private Map<String, double[]> mapQwithPolinom = new HashMap<>();
    private Map<String, double[]> mapPwithPolinom = new HashMap<>();

    private Map<String, Integer> mapQ = new HashMap<>();
    private Map<String, Integer> mapP = new HashMap<>();

    private int capacity;
    private int power;
    private String name;

    private ArrayList<Compressor> compressorsList = new ArrayList<>();

    public Compressor(UnitComplect unitComplect) {
        capacityFromComlect = unitComplect.getCapacity();
        evaporatingTemperatureFromComlect = unitComplect.getEvaporatingTemperature();
        condesionTemperatureFromComlect = unitComplect.getCondesionTemperature();
        airInletTemperatureFromComlect = unitComplect.getAirInletTemperature();
        Select();
    }

    private Compressor(double evaporatingTemperatureFromComlect, double condesionTemperatureFromComlect, double airInletTemperatureFromComlect, int capacity, int power, String name) {
        this.evaporatingTemperatureFromComlect = evaporatingTemperatureFromComlect;
        this.condesionTemperatureFromComlect = condesionTemperatureFromComlect;
        this.airInletTemperatureFromComlect = airInletTemperatureFromComlect;
        this.capacity = capacity;
        this.power = power;
        this.name = name;
    }

    private void Select() {
        AddCompressorsTo(mapQwithPolinom, mapPwithPolinom);
        selectCapacityCompressorTo(mapQ, mapP);
        searchCapacity();

    }

    private void AddCompressorsTo(Map mapQwithPolinom, Map mapPwithPolinom) {
        if (evaporatingTemperatureFromComlect < -19) {
            mapQwithPolinom.put("2GES-2Y", new double[]{11122.7303540869, 380.658467305785, -144.14742143662, 4.754801356, -3.577155938, 0.46064349, 0.021987013, -0.02976572, 0.000861025, -0.002214463});
            mapPwithPolinom.put("2GES-2Y", new double[]{623.408119, -23.88675038, 40.57732232, -0.638887738, 1.047849331, -0.270745597, -0.002765479, 0.006252371, -0.000434843, 0.00179437});
            mapQwithPolinom.put("2DES-2Y", new double[]{18922.83804, 660.2209596, -161.3076977, 8.19346053, -4.774816152, -0.835687885, 0.038425705, -0.042392462, -0.013233981, 0.003154927});
            mapPwithPolinom.put("2DES-2Y", new double[]{714.3214103, -48.93451983, 82.1142898, -1.332313432, 2, 316670765, -0.286911634, -0.007850225, 0.015527365, -0.00417182, -0.001891871});
            mapQwithPolinom.put("2CES-3Y", new double[]{22965.53373, 797.2406517, -191.5729957, 9.884870485, -5.695540183, -0.99790142, 0.046554282, -0.050703669, -0.016110629, 0.003277731});
            mapPwithPolinom.put("2CES-3Y", new double[]{862.0308333, -59.5298373, 98.80204499, -1.613014102, 2.767492188, -0.341274515, -0.00960554, 0.019078322, -0.005063836, -0.001783846});
            mapQwithPolinom.put("4EES-4Y", new double[]{32396.72499, 1176.002975, -288.8180463, 15.29900786, -9.258124125, -1.128412337, 0.072180401, -0.085190727, -0.015142425, 0.004665086});
            mapPwithPolinom.put("4EES-4Y", new double[]{1057.144981, -87.72194086, 141.1518586, -2.47688836, 3.821038825, -0.546535007, -0.017150445, 0.0024032444, -0.008241727, -0.001841129});
            mapQwithPolinom.put("4DES-5Y", new double[]{38556.18932, 1366.162203, -359.9557877, 17.50336463, -10.35420174, -0.823179353, 0.084193249, -0.087286168, -0.015667704, 0.002757253});
            mapPwithPolinom.put("4DES-5Y", new double[]{1397.137639, -104.1238802, 163.4273037, -2.984036879, 4.566278335, -0.705194993, -0.020718537, 0.029984609, -0.010724404, -0.000941648});
            mapQwithPolinom.put("4CES-6Y", new double[]{47113.46259, 1630.341571, -464.2732567, 20.56365256, -11.97090748, -0.523807238, 0.101468513, -0.088961496, -0.014519, 0.003025895});
            mapPwithPolinom.put("4CES-6Y", new double[]{1875.869468, -126.8147494, 192.9902637, -3.725034148, 5.665331472, -0.942544783, -0.025943838, 0.038751473, -0.014371736, 0.000173044});
            mapQwithPolinom.put("4TES-9Y", new double[]{62780.8534, 2205.857238, -701.5379294, 27.90188274, -18.30251021, 0.604302079, 0.134109992, -0.13820799, -0.004227668, -0.001921726});
            mapPwithPolinom.put("4TES-9Y", new double[]{2979.512424, -151.3675903, 212.8165349, -4.828574601, 7.496075034, -0.722911988, -0.0348305, 0.058308334, -0.016610353, -0.001103483});
            mapQwithPolinom.put("4NES-14Y", new double[]{81001.40914, 2912.202974, -710.0331243, 38.05844222, -20.60593021, -3.158833061, 0.185529318, -0.183891246, -0.052302519, 0.014652365});
            mapPwithPolinom.put("4NES-14Y", new double[]{2740.632209, -207.2286862, 350.1519908, -6.231369191, 9.732278468, -1.739606096, -0.04538319, 0.065285047, -0.020457131, -0.00347466});
            mapQwithPolinom.put("4HE-18Y", new double[]{106122.926017198, 3648.54445087451, -962.052831241062, 45.378313892483, -26.1850610167585, -2.77881199981254, 0.21841380048876, -0.210742041987939, -0.0508265478919247, 0.01172881442513170000});
            mapPwithPolinom.put("4HE-18Y", new double[]{4773.42020768492, -239.641263841292, 420.019375741228, -7.05948028299995, 12.3186570349467, -1.86515352115873, -0.0447522608005721, 0.0882712204960252, -0.0262535355782225, -0.00138685496513556000});
            mapQwithPolinom.put("4FE-28Y", new double[]{144635.230145086, 5011.77751470849, -1339.72647725202, 62.6583669782643, -39.4903126323403, -2.97527031037342, 0.289039424018832, -0.35387680556395700000, -0.05407581344019320000, 0.00692459097686226000});
            mapPwithPolinom.put("4FE-28Y", new double[]{7829.57408464468, -262.321871427874, 539.951266817906, -8.97409514250229, 14.2138772353708, -1.88156579932118, -0.0649238875994898, 0.08440739217652230000, -0.02164288669394000000, -0.00688541863313687000});
            mapQwithPolinom.put("6GE-34Y", new double[]{183994.494455619, 6244.95064979623, -1945.52564226448, 77.0719955756648, -50.6748495101108, 2.52113130828608, 0.358541254650732, -0.412341551373403, -0.033481609933495, -0.03251412157731660000});
            mapPwithPolinom.put("6GE-34Y", new double[]{12372.0581709203, -258.741261662394, 491.469455818265, -10.667957089754, 15.0359120355351, 1.38024792860718, -0.077083250568951, 0.114391144174723, 0.00992772820790505, -0.02528051936812130000});

        } else if (evaporatingTemperatureFromComlect >= -19) {
            mapQwithPolinom.put("2GES-2Y", new double[]{11122.7303540869, 380.658467305785, -144.14742143662, 4.754801356, -3.577155938, 0.46064349, 0.021987013, -0.02976572, 0.000861025, -0.002214463});
            mapPwithPolinom.put("2GES-2Y", new double[]{623.408119, -23.88675038, 40.57732232, -0.638887738, 1.047849331, -0.270745597, -0.002765479, 0.006252371, -0.000434843, 0.00179437});
            mapQwithPolinom.put("2FES-3Y", new double[]{14362.95051, 494.6251956, -200.6048075, 6.152107767, -5.077580853, 0.806250945, 0.027447146, -0.042977729, 0.003394082, -0.003976999});
            mapPwithPolinom.put("2FES-3Y", new double[]{721.6454808, -29.71914863, 49.71008751, -0.820618545, 1.244295489, -0.287105071, -0.004162141, 0.007978329, 0.001006548, 0.001815477});
            mapQwithPolinom.put("2DES-3Y", new double[]{18950.02851, 677.8448815, -157.8654758, 8.838400714, -4.921612574, -0.887007116, 0.041795761, -0.053491017, -0.018415732, 0.002245414});
            mapPwithPolinom.put("2DES-3Y", new double[]{767.1035104, -44.58928097, 78.79551242, -1.216138474, 2.136772226, -0.309258077, -0.0071635, 0.013030005, -0.004424539, -0.001648041});
            mapQwithPolinom.put("4FES-5Y", new double[]{25725.97849, 979.9476344, -222.0416577, 13.52397591, -8.134929611, -1.059944164, 0.062810914, -0.094281837, -0.020048027, 0.002018937});
            mapPwithPolinom.put("4FES-5Y", new double[]{913.7174828, -59.94938667, 107.0029912, -1.65955759, 2.650464214, -0.460198911, -0.011423067, 0.013380777, -0.00749889, -0.001900177});
            mapQwithPolinom.put("4EES-6Y", new double[]{32527.36521, 1213.85588, -294.2119412, 16.55039976, -9.750017297, -1.05513656, 0.078422031, -0.106899991, -0.023336121, 0.002169149});
            mapPwithPolinom.put("4EES-6Y", new double[]{1160.212149, -81.23630086, 135.7348002, -2.305742845, 3.612311719, -0.59565723, -0.015923301, 0.020981177, -0.00924176, -0.001895719});
            mapQwithPolinom.put("4DES-7Y", new double[]{38731.14586, 1403.899293, -362.4159677, 18.89239577, -10.64235161, -0.662188339, 0.091870009, -0.110219183, -0.026728829, -0.001505978});
            mapPwithPolinom.put("4DES-7Y", new double[]{1505.092532, -95.35376496, 157.8735706, -2.739373344, 4.237578263, -0.760845887, -0.018990496, 0.025314374, -0.011426265, -0.000532657});
            mapQwithPolinom.put("4CES-9Y", new double[]{47349.68964, 1667.604464, -476.3575588, 22.14545685, -12.03818709, 0.012095877, 0.111377534, -0.112972424, -0.028941013, -0.005247028});
            mapPwithPolinom.put("4CES-9Y", new double[]{1875.869468, -126.8147493, 192.9902637, -3.725034148, 5.665331472, -0.942544783, -0.025943838, 0.038751473, -0.014371736, 0.000173044});
            mapQwithPolinom.put("4TES-12Y", new double[]{63086.5673278653, 2262.06833570341, -705.732527495013, 30.1282576554521, -18.440393220245, 0.828550351519943, 0.148838684374921, -0.168366196304116, -0.0227512279986296, -0.00784760532650129});
            mapPwithPolinom.put("4TES-12Y", new double[]{2975.58989196419, -149.163245321199, 212.360683599473, -4.76980846741647, 7.32870403935496, -0.993808269022314, -0.0351581512255829, 0.0542710018683652, -0.0211602955986787, 0.000907459501712045});
            mapQwithPolinom.put("4PES-15Y", new double[]{73553.04807, 2655.282233, -832.2179022, 35.5118436, -21.61638018, 0.691818674, 0.176425129, -0.196721549, -0.029515177, -0.005590172});
            mapPwithPolinom.put("4PES-15Y", new double[]{3511.58431, -171.5884354, 242.134937, -5.572769194, 8.555116905, -1.108410131, -0.040882086, 0.063667887, -0.022952113, -0.001026567});
            mapQwithPolinom.put("4NES-20Y", new double[]{85949.87243, 3081.58026, -962.152133, 41.13597428, -25.035404, 1.216430619, 0.204183823, -0.228543056, -0.031649069, -0.011699051});
            mapPwithPolinom.put("4NES-20Y", new double[]{4025.90873, -204.8396087, 287.0214705, -6.546955643, 9.993127256, -1.374032603, -0.048572205, 0.075827634, -0.029550472, 0, 001740451});
            mapQwithPolinom.put("4HE-25Y", new double[]{106156.119835214, 3740.84278347502, -977.265450967639, 48.9790766909472, -26.8322896726659, -2.36464686388056, 0.238296417814724, -0.269907862985295, -0.0821072438868979, 0.001488896415229});
            mapPwithPolinom.put("4HE-25Y", new double[]{4945.12828351781, -214.226565969323, 399.944458996326, -6.40232558548291, 11.3032569724245, -1.94171976518851, -0.0410324104117682, 0.0726066667824603, -0.027146033272811, -0.00161431234842844});
        }
    }

    private void selectCapacityCompressorTo(Map mapQ, Map mapP) {
        for (Map.Entry entry : mapQwithPolinom.entrySet()) {
            String nameCompressor = (String) entry.getKey();
            double[] polinom = (double[]) entry.getValue();
            int capacityCompressor = (int) (
                    polinom[0] +
                            polinom[1] * evaporatingTemperatureFromComlect +
                            polinom[2] * condesionTemperatureFromComlect +
                            polinom[3] * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[4] * evaporatingTemperatureFromComlect * condesionTemperatureFromComlect +
                            polinom[5] * (condesionTemperatureFromComlect * condesionTemperatureFromComlect) +
                            polinom[6] * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[7] * condesionTemperatureFromComlect * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[8] * evaporatingTemperatureFromComlect * (condesionTemperatureFromComlect * condesionTemperatureFromComlect) +
                            polinom[9] * (condesionTemperatureFromComlect * condesionTemperatureFromComlect * condesionTemperatureFromComlect));
            mapQ.put(nameCompressor, capacityCompressor);
        }
        for (Map.Entry entry : mapPwithPolinom.entrySet()) {
            String nameCompressor = (String) entry.getKey();
            double[] polinom = (double[]) entry.getValue();
            int powerCompressor = (int) (
                    polinom[0] +
                            polinom[1] * evaporatingTemperatureFromComlect +
                            polinom[2] * condesionTemperatureFromComlect +
                            polinom[3] * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[4] * evaporatingTemperatureFromComlect * condesionTemperatureFromComlect +
                            polinom[5] * (condesionTemperatureFromComlect * condesionTemperatureFromComlect) +
                            polinom[6] * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[7] * condesionTemperatureFromComlect * (evaporatingTemperatureFromComlect * evaporatingTemperatureFromComlect) +
                            polinom[8] * evaporatingTemperatureFromComlect * (condesionTemperatureFromComlect * condesionTemperatureFromComlect) +
                            polinom[9] * (condesionTemperatureFromComlect * condesionTemperatureFromComlect * condesionTemperatureFromComlect));
            mapP.put(nameCompressor, powerCompressor);
        }
    }

    public ArrayList sortedMapToValue(Map<String, Integer> mapQ) {
        ArrayList listCapacity = new ArrayList(mapQ.entrySet());
        Collections.sort(listCapacity, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return listCapacity;
    }

    private void searchCapacity() {
        ArrayList<Integer> list = new ArrayList();

        for (Object i : sortedMapToValue(mapQ)) {
            char[] chars = i.toString().toCharArray();
            ArrayList arrayList = new ArrayList();
            for (int j = chars.length - 1; j > -1; j--) {
                if (chars[j] != '=') arrayList.add(0, chars[j]);
                else break;
            }
            list.add(Integer.parseInt(getStringRepresentation(arrayList)));
        }

        int capacityTwo = 0;
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k) >= capacityFromComlect) {
                capacity = list.get(k);
                if (k > 0) {
                    capacityTwo = list.get(k - 1);
                }
                break;
            }
        }

        for (Map.Entry<String, Integer> entry : mapQ.entrySet()) {
            if (entry.getValue() == capacity) {
                name = entry.getKey();
                for (Map.Entry<String, Integer> entry1 : mapP.entrySet()) {
                    if (entry1.getKey() == name) {
                        power = entry1.getValue();
                    }
                }
                Compressor compressor = new Compressor(evaporatingTemperatureFromComlect, condesionTemperatureFromComlect,airInletTemperatureFromComlect, capacity, power, name);
                compressorsList.add(compressor);
            }
        }

        if (capacityTwo != 0) {
            for (Map.Entry<String, Integer> entry : mapQ.entrySet()) {
                if (entry.getValue() == capacityTwo) {
                    name = entry.getKey();
                    capacity = entry.getValue();
                    for (Map.Entry<String, Integer> entry1 : mapP.entrySet()) {
                        if (entry1.getKey() == name) {
                            power = entry1.getValue();
                        }
                    }
                    Compressor compressor = new Compressor(evaporatingTemperatureFromComlect, condesionTemperatureFromComlect,airInletTemperatureFromComlect, capacity, power, name);
                    compressorsList.add(0, compressor);
                }
            }
        }

    }

    private String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Compressor> getCompressorsList() {
        return compressorsList;
    }

    public double getEvaporatingTemperatureFromComlect() {
        return evaporatingTemperatureFromComlect;
    }

    public double getCondesionTemperatureFromComlect() {
        return condesionTemperatureFromComlect;
    }

    public double getAirInletTemperatureFromComlect() {
        return airInletTemperatureFromComlect;
    }

}
