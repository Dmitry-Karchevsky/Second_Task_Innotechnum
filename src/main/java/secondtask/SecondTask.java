package secondtask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SecondTask {
    public static void main(String[] args) {
        List<Pair> arrayListA = ReadFile.readFileInList(args[0]);
        List<Pair> arrayListB = ReadFile.readFileInList(args[1]);

        String resultArrayList = Calculate.ArrayListInnerJoin(arrayListA, arrayListB);
        System.out.println(resultArrayList);
        System.out.println();

        String resultLinkedList = Calculate.LinkedListInnerJoin(new LinkedList<>(arrayListA), new LinkedList<>(arrayListB));
        System.out.println(resultLinkedList);
        System.out.println();

        String resultHashMap = Calculate.HashMapInnerJoin(listToMap(arrayListA), listToMap(arrayListB));
        System.out.println(resultHashMap);
    }

    private static Map<Integer, Pair> listToMap (List<Pair> list){
        Map<Integer, Pair> map = new HashMap<>();
        int id = 0;
        for (Pair pair : list){
            map.put(id, pair);
            id++;
        }
        return map;
    }
}
