package mobi.zishun;

import java.util.*;

public class BreadthFirstSearch {
    private static final Map<String, List<String>> graph = new HashMap<>();

    private static String breadthFirstSearch(String name) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        // This list is how you keep track of which people you've searched before.
        List<String> searched = new ArrayList<>(); //优化算法：避免重复判断同一个人情况（人脉交叉情况，有可能导致无限循环查找）

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll(); //poll() 移除和返回队列的头
            // Only search this person if you haven't already searched them
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    return person + " is a mango seller";
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return " Nobody is a mango seller";
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m"); //返回以“m"结尾的名字（代指卖家）
    }

    public static void main(String[] args) {
        graph.put("You", Arrays.asList("Alice", "Bob", "Claire"));
        graph.put("Alice", Collections.singletonList("Peggy"));
        graph.put("Bob", Arrays.asList("Anuj", "Peggy"));
        graph.put("Claire", Arrays.asList("Jonny", "Thom"));
        graph.put("Peggy", Collections.emptyList());
        graph.put("Anuj", Collections.emptyList());
        graph.put("Jonny", Collections.emptyList());
        graph.put("Thom", Collections.emptyList());

        //System.out.println(graph);
        // {Claire=[Jonny, Thom], Peggy=[], Jonny=[], Bob=[Anuj, Peggy], Thom=[], Alice=[Peggy], Anuj=[], You=[Alice, Bob, Claire]}
        System.out.println(breadthFirstSearch("You"));
    }
}
