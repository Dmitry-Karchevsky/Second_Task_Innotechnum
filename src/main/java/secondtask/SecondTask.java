package secondtask;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter(args[0], false))
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
            for (int i = 0; i < 10000; i++) {
                b.append((int) (Math.random() * 5 + 1)).append(",").append((char)(( 'A') + (Math.random() * 5))).append("\n");
            }
            writer.write(b.toString());
            writer.flush();
        } catch (IOException e) {}

        System.out.println("запись");
        List<Pair> arrayListA = ReadFile.readFileInList(args[0]);
        List<Pair> arrayListB = ReadFile.readFileInList(args[1]);
        System.out.println("считал");

        String resultArrayList = Calculate.ArrayListInnerJoin(arrayListA, arrayListB);
        System.out.println("ArrayListInnerJoin");
        //System.out.println(resultArrayList);
        System.out.println();


        Collections.sort(arrayListA);
        Collections.sort(arrayListB);

        //System.out.println(arrayListA);
        //System.out.println(arrayListB);

        List<Triplet> resultLinkedList = Calculate.LinkedListInnerJoin(new LinkedList<>(arrayListA), new LinkedList<>(arrayListB));
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
