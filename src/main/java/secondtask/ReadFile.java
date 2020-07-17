package secondtask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Pair> readFileInList(String fileName){
        List<Pair> table = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            String line = fileReader.readLine();
            while (line != null) {
                String[] info = line.split(",");
                table.add(new Pair(Integer.parseInt(info[0]), info[1]));
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл для считывания данных: %s не найден\n", fileName);
            return null;
        }
        catch (IOException e){
            System.out.printf("Ошибка при чтении данных из файла: %s\n", fileName);
            return null;
        }
        return table;
    }
}
