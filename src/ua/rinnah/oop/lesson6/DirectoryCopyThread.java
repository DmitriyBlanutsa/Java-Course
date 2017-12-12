package ua.rinnah.oop.lesson6;

import java.io.File;
import java.util.Arrays;

public class DirectoryCopyThread {

    private File source;
    private File receiver;

    public DirectoryCopyThread(File source, File receiver) {
        this.source = source;
        this.receiver = receiver;
    }

    public DirectoryCopyThread() {
    }

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public File getReceiver() {
        return receiver;
    }

    public void setReceiver(File receiver) {
        this.receiver = receiver;
    }

    public void copy(){
        if (!receiver.exists()) {
            receiver.mkdir();
        }
        if (receiver.isDirectory()){
            File[] files = source.listFiles();
            System.out.println(Arrays.toString(files));
            int p = files.length;
            FileCopyThread[] fct = new FileCopyThread[p];
            Thread[] threads = new Thread[p];
            for (int i = 0; i < p; i++){
                fct[i] = new FileCopyThread(files[i], receiver);
                threads[i] = new Thread(fct[i]);
                threads[i].start();
                try {
                    threads[i].join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Directory is copied!!!");
        }else {
            System.out.println("File not found!!!");
        }
    }
}
