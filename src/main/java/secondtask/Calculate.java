package secondtask;

import java.util.*;

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

    public static List<Triplet> LinkedListInnerJoin(List<Pair> listA, List<Pair> listB){
        //LinkedList a = new LinkedList();
        //a.get();
        //System.out.println(listA);
        listA.retainAll(listB);
        listB.retainAll(listA);
        //listB.retainAll(listA);
        System.out.println(listA);
        System.out.println(listB);
        return null;
        /*List<Triplet> result = new ArrayList<>();
        Iterator<Pair> leftIter = listA.listIterator();
        ListIterator<Pair> rightIter = listB.listIterator();
        Pair leftPair = leftIter.next();
        Pair rightPair = rightIter.next();

        while (true)  {
            int compare = leftPair.getId() - (rightPair.getId());
            if (compare < 0) {
                if (leftIter.hasNext()) {
                    leftPair = leftIter.next();
                } else {
                    break;
                }
            } else if (compare > 0) {
                if (rightIter.hasNext()) {
                    rightPair = rightIter.next();
                } else {
                    break;
                }
            } else {
                Iterator<Pair> rightIterTemp = rightIter;
                while (leftIter.hasNext() && rightIterTemp.hasNext() && (leftPair.getId() == rightPair.getId())){
                    result.add(new Triplet(leftPair.getId(), leftPair.getValue(), rightPair.getValue()));
                    rightPair = rightIterTemp.next();
                }
                //result.add(new Triplet(leftPair.getId(), leftPair.getValue(), rightPair.getValue()));
                if (leftIter.hasNext() && rightIterTemp.hasNext()) {
                    leftPair = leftIter.next();
                    //rightPair = rightIter.next();
                } else {
                    break;
                }
            }
        }
        return result;*/
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
