package ua.rinnah.oop.lesson9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CharStatisticFromFile{

    public static void getStatisticStreamAPI(File file){
        if (!check(file)){
            return;
        }
        try {
            Files.lines(Paths.get(file.getAbsolutePath()))
                    .map(n -> n.toLowerCase())
                    .flatMapToInt(n -> n.chars())
                    .filter(n -> n>='a' && n<='z')
                    .mapToObj(n -> Character.valueOf((char)n))
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> (int) (b.getValue() - a.getValue()))
                    .forEach(n -> System.out.println(n.getKey() + " " + n.getValue()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void getStatisticSimple(File file){
        final int VALUE_OF_a = 97;
        if (!check(file)){
            return;
        }
        List<List<Integer>> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++){
            list.add( new ArrayList<Integer>(2));
            list.get(i).add(i);
            list.get(i).add(0);
        }
        String str = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true){
                str = br.readLine();
                if (str == null) {
                    break;
                }
                for (Character element : str.toCharArray()){
                    if (element >= 'a' && element <= 'z') {
                        list.get(element - VALUE_OF_a).set(1, list.get(element - VALUE_OF_a).get(1) + 1);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        list.sort( (a,b)-> b.get(1) - a.get(1));
        for (List<Integer> element : list){
            if (element.get(1) != 0)
                System.out.println((char) (element.get(0) + VALUE_OF_a) + " " + element.get(1));
        }
    }

    private static boolean check(File file){
        try {
            if (file == null) {
                throw new IllegalArgumentException("File is empty!!!");
            }
            if (file.isDirectory()) {
                throw new IllegalArgumentException("File is directory!!!");

            }
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
