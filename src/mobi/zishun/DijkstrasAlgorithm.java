package mobi.zishun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DijkstrasAlgorithm {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    private static String findLowestCostNode(Map<String, Integer> costs) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (String node : costs.keySet()) {
            int cost = costs.get(node);
            if (lowestCost > cost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode; //如果processed数组中已包含所有节点，将返回null
    }

    public static void main(String[] args) {
        //节点start
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);
        //节点a
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1);
        //节点b
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);
        //节点fin（终点）
        graph.put("fin", new HashMap<>()); //终点没有任何邻居
//        System.out.println(graph.get("start").get("a")); //6
//        System.out.println(graph.get("start").keySet()); //[a,b]

        //the costs table 存储每个节点的开销
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE); //2147483647

        //the parents nodes 存储父节点: value是key的父节点
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        //DijkstrasAlgorithm 算法主体
        String node;
        node = findLowestCostNode(costs); //在未处理的节点中找出开销最小的节点

        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbours = graph.get(node);

            for (String n : neighbours.keySet()) {
                int newCost = cost + neighbours.get(n);
                if (newCost < costs.get(n)) { //判断经过node节点的新路径是否小于原路径
                    costs.put(n, newCost);
                    parents.put(n, node); //修改正在遍历节点的父节点到目前所在的node节点
                }
            }
            processed.add(node);

            node = findLowestCostNode(costs); //继续处理更新后的costs的剩余node，遍历到所有节点都处理过（在processes数组中）
        }

        System.out.println(costs);
//        System.out.println(Double.POSITIVE_INFINITY); //Infinity
    }
}
