package ua.rinnah.oop.lesson6;

import java.io.*;

public class FileCopyThread implements Runnable {

    private File file;
    private File directory;

    public FileCopyThread(File file, File directory) {
        this.file = file;
        this.directory = directory;
    }

    public FileCopyThread() {
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private void copy(){
        if (file.exists()) {
            try (InputStream in = new FileInputStream(file);
                 OutputStream out = new FileOutputStream(directory + "\\" + file.getName() )){
                int size = in.available() > 1024*1024? 1024*1024 : in.available();
                byte[] byffer = new byte[size];
                int n;
                do{
                    n = in.read(byffer);
                    out.write(byffer);
                }while(n == 1024*1024);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("file " + file.getName() + " is not exist");
        }
    }

    @Override
    public void run() {
        copy();
    }
}
