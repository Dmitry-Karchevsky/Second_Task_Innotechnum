package secondtask;

import java.util.*;

public class Calculate {

    public static List<Triplet> arrayListInnerJoin(ArrayList<Pair> listA, ArrayList<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        for (Pair pairA : listA){
            for (Pair pairB : listB){
                if (pairA.getId() == pairB.getId())
                    result.add(new Triplet(pairA.getId(), pairA.getValue(), pairB.getValue()));
            }
        }
        return result;
    }

    public static List<Triplet> linkedListInnerJoin(LinkedList<Pair> listA, LinkedList<Pair> listB){
        List<Triplet> result = new ArrayList<>();
        Iterator<Pair> leftIter = listA.listIterator();
        ListIterator<Pair> rightIter = listB.listIterator();
        Pair leftPair = leftIter.next();
        Pair rightPair = rightIter.next();

        List<String> nowVariants = new ArrayList<>();

        while (leftIter.hasNext() && rightIter.hasNext()) {
            int compare = leftPair.getId() - rightPair.getId();
            if (compare < 0) {
                leftPair = leftIter.next();
            } else if (compare > 0) {
                rightPair = rightIter.next();
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
                nowVariants = new ArrayList<>();
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
