package mobi.zishun;

import java.util.*;

public class SetCovering {
    private static Set<String> statesNeeded = new HashSet<>();
    private static Map<String, Set<String>> stations = new LinkedHashMap<>();
    private static Set<String> finalStations = new LinkedHashSet<>();

    public static void main(String[] args) {
        statesNeeded.addAll(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (Map.Entry<String, Set<String>> station : stations.entrySet()) { //遍历stations集合里的每个value（也是集合）
                Set<String> covered = new HashSet<>(station.getValue());
                covered.retainAll(statesNeeded); //与statesNeeded做交集

                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                    finalStations.add(station.getKey());
                    statesNeeded.removeAll(station.getValue());
                }
            }
        }

        System.out.println(finalStations);
    }
}
