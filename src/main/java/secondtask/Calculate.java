package secondtask;

import java.util.*;

public class Calculate {

    public static List<Triplet> arrayListInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.add(new Triplet(pairA.getId(), pairA.getValue(), pairB.getValue()));
            }
        }
        return result;
    }

    public static List<Triplet> linkedListInnerJoin(List<Pair> listA, List<Pair> listB){
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

    public static List<Triplet> linkedListInnerJoin2(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Iterator<Pair> leftIter = listA.listIterator();
        ListIterator<Pair> rightIter = listB.listIterator();
        Pair leftPair = leftIter.next();
        Pair rightPair = rightIter.next();

        List<String> nowVariants = new ArrayList<>();

        while (true) {
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
                while (leftPair.getId() == rightPair.getId()) {
                    nowVariants.add(rightPair.getValue());
                    if (!rightIter.hasNext())
                        break;
                    rightPair = rightIter.next();
                }

                while (rightPair.getId() > leftPair.getId() || !rightIter.hasNext()) {
                    for (String s : nowVariants) {
                        result.add(new Triplet(leftPair.getId(), leftPair.getValue(), s));
                    }
                    if (leftIter.hasNext())
                        leftPair = leftIter.next();
                    else
                        break;
                }

                if (!leftIter.hasNext()) {
                    break;
                }

                nowVariants = new ArrayList<>();
            }
        }
        return result;
    }

    public static List<Triplet> linkedListInnerJoin3(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Iterator<Pair> leftIter = listA.listIterator();
        ListIterator<Pair> rightIter = listB.listIterator();
        Pair leftPair = leftIter.next();
        Pair rightPair = rightIter.next();

        int id = 0;
        boolean check = true;

        while (true) {
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
                    check = true;
                } else {
                    break;
                }
            } else {
                if (check) {
                    id = rightIter.previousIndex();
                    check = false;
                }
                while (leftPair.getId() == rightPair.getId()){
                    result.add(new Triplet(leftPair.getId(), leftPair.getValue(), rightPair.getValue()));
                    if (rightIter.hasNext())
                        rightPair = rightIter.next();
                    else
                        break;
                }
                if (leftIter.hasNext()) {
                    leftPair = leftIter.next();
                    rightIter = listB.listIterator(id);
                    rightPair = rightIter.next();
                }
                else
                    break;
            }
        }
        return result;
    }

    public static List<Triplet> hashMapInnerJoin(List<Pair> listA, List<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Map<Integer, List<String>> mapA = new HashMap<>();
        Map<Integer, List<String>> mapB = new HashMap<>();

        for (Pair tempPairA : listA) {
            List<String> variantsList = mapA.getOrDefault(tempPairA.getId(), new ArrayList<>());
            variantsList.add(tempPairA.getValue());
            mapA.put(tempPairA.getId(), variantsList);
        }

        for (Pair tempPairB : listB) {
            List<String> variantsList = mapB.getOrDefault(tempPairB.getId(), new ArrayList<>());
            variantsList.add(tempPairB.getValue());
            mapB.put(tempPairB.getId(), variantsList);
        }

        for (Map.Entry<Integer, List<String>> tempPairB : mapB.entrySet()) {
            List<String> lstVariantsA = mapA.get(tempPairB.getKey());
            if (lstVariantsA != null) {
                for (String goodValueA : lstVariantsA){
                    for (String goodValueB : tempPairB.getValue())
                        result.add(new Triplet(tempPairB.getKey(), goodValueA, goodValueB));
                }
            }
        }
        return result;
    }
}
