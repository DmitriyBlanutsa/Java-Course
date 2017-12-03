package ua.rinnah.oop.lesson5;

import java.io.*;
import java.util.*;

public class FileCopy{

    public static void fileFilterCopy(String[] extension, File source, File receiver) {
        File[] arrFiles = getFileFilter(extension, source);
        for (File file : arrFiles) {
            File newFile = new File(receiver + "\\" + file.getName());
            System.out.println(receiver + "\\" + file.getName());
            try (InputStream fin = new FileInputStream(file);
                 OutputStream fout = new FileOutputStream(newFile)) {
                byte[] buffer = new byte[1024 * 1024];
                int n;
                do {
                    n = fin.read(buffer);
                    fout.write(buffer);
                } while (n != -1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static File[] getFileFilter(String[] extension, File source){
        File[] arrFiles = source.listFiles((dir, name) -> {
            int point = name.lastIndexOf(".");
            if (point == -1)
                return false;
            String ext = name.substring(point + 1, name.length());
            for (String str : extension) {
                if (str.equals(ext))
                    return true;
            }
            return false;
        });
        return  arrFiles;
    }

    public static void commonWords(File file1, File file2, File common){
        try(PrintWriter w = new PrintWriter(common)){
            Set<String> set1 = wordsFromFile(file1);
            Set<String> set2 = wordsFromFile(file2);
            set2.retainAll(set1);
            for (String str : set2)
               w.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static Set<String> wordsFromFile(File file){
        Set<String> set = null;
        try(BufferedReader r = new BufferedReader(new FileReader(file))){
            set = new HashSet<>();
            String buffer;
            while(true){
                buffer = r.readLine();
                if (buffer == null)
                    break;
                set.addAll(Arrays.asList(buffer.split(" ")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return set;
    }

}

