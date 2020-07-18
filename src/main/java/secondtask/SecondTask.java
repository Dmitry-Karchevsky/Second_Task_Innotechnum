package secondtask;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SecondTask {
    public static void main(String[] args) {

        //args = new String[]{"src\\main\\resources\\SimpleFile1.txt", "src\\main\\resources\\SimpleFile2.txt"};
        args = new String[]{"src\\main\\resources\\InputFile1.txt", "src\\main\\resources\\InputFile2.txt"};

        /*try(FileWriter writer = new FileWriter(args[0], false))
        {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                b.append((int) (Math.random() * 5 + 1)).append(",").append((char)(( 'A') + (Math.random() * 5 + 1))).append("\n");
            }
            writer.write(b.toString());
            writer.flush();
        } catch (IOException e) {}

        try(FileWriter writer = new FileWriter(args[1], false))
        {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < 50000; i++) {
                b.append((int) (Math.random() * 5 + 1)).append(",").append((char)(( 'A') + (Math.random() * 5))).append("\n");
            }
            writer.write(b.toString());
            writer.flush();
        } catch (IOException e) {}*/

        Date start, end;

        List<Pair> arrayListA = ReadFile.readFileInList(args[0]);
        List<Pair> arrayListB = ReadFile.readFileInList(args[1]);

        //ArrayListInnerJoin
        System.out.println("Start TestInnerJoin");
        start = new Date();
        List<Triplet> resultTestList = Calculate.TestInnerJoin(arrayListA, arrayListB);
        end = new Date();
        resultTestList = null;
        System.gc();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End TestInnerJoin");
        //System.out.println(resultTestList);
        System.out.println();

        //ArrayListInnerJoin
        /*System.out.println("Start ArrayListInnerJoin");
        start = new Date();
        List<Triplet> resultArrayList = Calculate.TestInnerJoin(arrayListA, arrayListB);
        end = new Date();
        //resultArrayList = null;
        //System.gc();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End ArrayListInnerJoin");
        System.out.println(resultArrayList);
        System.out.println();*/

        Collections.sort(arrayListA);
        Collections.sort(arrayListB);

        List<Pair> testlist = new LinkedList<>(arrayListA);
        List<Pair> testlist2 = new LinkedList<>(arrayListB);

        //LinkedListInnerJoin
        System.out.println("Start LinkedListInnerJoin");
        start = new Date();
        List<Triplet> resultLinkedList = Calculate.LinkedListInnerJoin(testlist, testlist2);
        end = new Date();
        resultLinkedList = null;
        System.gc();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End LinkedListInnerJoin");
        //System.out.println(resultLinkedList);
        System.out.println();

        //HashMapInnerJoin
        System.out.println("Start HashMapInnerJoin");
        start = new Date();
        List<Triplet> resultHashMap = Calculate.HashMapInnerJoin(arrayListA, arrayListB);
        end = new Date();
        System.out.println("Time :" + (end.getTime() - start.getTime()));
        System.out.println("End HashMapInnerJoin");
        //System.out.println(resultHashMap);
    }
}
