package secondtask;

import java.util.List;
import java.util.Map;

public class Calculate {
    public static String ArrayListInnerJoin(List<Pair> listA, List<Pair> listB){
        StringBuilder result = new StringBuilder();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.append(pairA.getId()).
                            append(" ").
                            append(pairA.getValue()).
                            append(" ").
                            append(pairB.getValue()).
                            append("\n");
            }
        }
        return result.toString();
    }

    public static String LinkedListInnerJoin(List<Pair> listA, List<Pair> listB){
        StringBuilder result = new StringBuilder();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.append(pairA.getId()).
                            append(" ").
                            append(pairA.getValue()).
                            append(" ").
                            append(pairB.getValue()).
                            append("\n");
            }
        }
        return result.toString();
    }

    public static String HashMapInnerJoin(Map<Integer, Pair> mapA, Map<Integer, Pair> mapB){
        StringBuilder result = new StringBuilder();
        for (Pair pairA : mapA.values()){
            for (Pair pairB : mapB.values()){
                if (pairA.getId() == pairB.getId())
                    result.append(pairA.getId()).
                            append(" ").
                            append(pairA.getValue()).
                            append(" ").
                            append(pairB.getValue()).
                            append("\n");
            }
        }
        return result.toString();
    }
}
