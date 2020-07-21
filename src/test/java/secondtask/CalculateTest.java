package secondtask;

import org.junit.jupiter.api.Test;

import java.util.*;

class CalculateTest {

    private List<Pair> arrayListA;
    private List<Pair> arrayListB;
    private Date start, end;

    {
        String[] args;
        args = new String[]{"src\\main\\resources\\SimpleFile1.txt", "src\\main\\resources\\SimpleFile2.txt"};
        //args = new String[]{"src\\main\\resources\\InputFile1.txt", "src\\main\\resources\\InputFile2.txt"};

        arrayListA = ReadFile.readFileInList(args[0]);
        arrayListB = ReadFile.readFileInList(args[1]);
    }

    @Test
    void arrayListInnerJoin() {
        System.out.println("Start ArrayListInnerJoin");
        start = new Date();
        List<Triplet> resultArrayList = Calculate.arrayListInnerJoin(arrayListA, arrayListB);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End ArrayListInnerJoin");
        //System.out.println(resultArrayList);
    }

    @Test
    void linkedListInnerJoin() {
        Collections.sort(arrayListA);
        Collections.sort(arrayListB);

        List<Pair> testlist = new LinkedList<>(arrayListA);
        List<Pair> testlist2 = new LinkedList<>(arrayListB);

        System.out.println("Start LinkedListInnerJoin");
        start = new Date();
        List<Triplet> resultLinkedList = Calculate.linkedListInnerJoin(testlist, testlist2);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End LinkedListInnerJoin");
        //System.out.println(resultLinkedList);
    }

    @Test
    void linkedListInnerJoin2() {
        Collections.sort(arrayListA);
        Collections.sort(arrayListB);

        List<Pair> testlist = new LinkedList<>(arrayListA);
        List<Pair> testlist2 = new LinkedList<>(arrayListB);

        System.out.println("Start LinkedListInnerJoin2");
        start = new Date();
        List<Triplet> resultLinkedList2 = Calculate.linkedListInnerJoin2(testlist, testlist2);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End LinkedListInnerJoi2");
        //System.out.println(resultLinkedList2);
    }

    @Test
    void linkedListInnerJoin3() {
        Collections.sort(arrayListA);
        Collections.sort(arrayListB);

        List<Pair> testlist = new LinkedList<>(arrayListA);
        List<Pair> testlist2 = new LinkedList<>(arrayListB);

        System.out.println("Start LinkedListInnerJoin3");
        start = new Date();
        List<Triplet> resultLinkedList3 = Calculate.linkedListInnerJoin3(testlist, testlist2);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End LinkedListInnerJoi3");
        //System.out.println(resultLinkedList3);
    }

    @Test
    void hashMapInnerJoin() {
        System.out.println("Start HashMapInnerJoin");
        start = new Date();
        List<Triplet> resultHashMap = Calculate.hashMapInnerJoin(arrayListA, arrayListB);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End HashMapInnerJoin");
        //System.out.println(resultHashMap);
    }
}