package secondtask;

import java.util.*;

public class Calculate {
    public static List<Triplet> TestInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.add(new Triplet(pairA.getId(), pairA.getValue(), pairB.getValue()));
            }
        }
        return result;
    }

    public static List<Triplet> ArrayListInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.add(new Triplet(pairA.getId(), pairA.getValue(), pairB.getValue()));
            }
        }
        return result;
    }

    public static List<Triplet> LinkedListInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Iterator<Pair> leftIter = listA.listIterator();
        ListIterator<Pair> rightIter = listB.listIterator();
        Pair leftPair = leftIter.next();
        Pair rightPair = rightIter.next();

        while (true)  {
            int compare = leftPair.getId() - rightPair.getId();
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
                Iterator<Pair> rightIterTemp = listB.listIterator(rightIter.previousIndex());
                Pair rightPairTemp = rightIterTemp.next();
                while (rightIterTemp.hasNext() && (leftPair.getId() == rightPairTemp.getId())){
                    result.add(new Triplet(leftPair.getId(), leftPair.getValue(), rightPairTemp.getValue()));
                    rightPairTemp = rightIterTemp.next();
                }

                if (leftIter.hasNext()) {
                    leftPair = leftIter.next();
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /*public static List<Triplet> HashMapInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>();

        // по хорошему при больших объемах данных нужно мапу заполнять меньшим из листов
        for (Pair tempPairA : listA) {
        //for (Pair tempPairMin : listA.size() < listB.size() ? listA : listB) {
            List<Pair> variantsList = map.getOrDefault(tempPairA.getId(), new ArrayList<>());
            variantsList.add(tempPairA);
            map.put(tempPairA.getId(), variantsList);
        }

        for (Pair tempPairB : listB) {
        //for (Pair tempPairMax : listA.size() > listB.size() ? listA : listB) {
            List<Pair> lst = map.get(tempPairB.getId());
            if (lst != null) {
                //https://habr.com/ru/post/192130/ про foreach
                //lst.forEach(r -> result.add(new String[][]{r, tempPairB})); // можно и так
                for (Pair goodPair : lst){
                    result.add(new Triplet(goodPair.getId(), goodPair.getValue(), tempPairB.getValue()));
                }
            }
        }
        return result;
    }*/

    public static List<Triplet> HashMapInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();

        // по хорошему при больших объемах данных нужно мапу заполнять меньшим из листов
        for (Pair tempPairA : listA) {
            //for (Pair tempPairMin : listA.size() < listB.size() ? listA : listB) {
            List<String> variantsList = map.getOrDefault(tempPairA.getId(), new ArrayList<>());
            variantsList.add(tempPairA.getValue());
            map.put(tempPairA.getId(), variantsList);
        }

        for (Pair tempPairB : listB) {
            //for (Pair tempPairMax : listA.size() > listB.size() ? listA : listB) {
            List<String> lst = map.get(tempPairB.getId());
            if (lst != null) {
                //https://habr.com/ru/post/192130/ про foreach
                lst.forEach(r -> result.add(new Triplet(tempPairB.getId(), r, tempPairB.getValue()))); // можно и так
                /*for (String goodValue : lst){
                    result.add(new Triplet(tempPairB.getId(), goodValue, tempPairB.getValue()));
                }*/
            }
        }
        return result;
    }
}
