package ua.rinnah.oop.lesson3_4;

public class SizeGroupExeption extends Exception{

    @Override
    public String getMessage() {
        return "Group if full!!!\r\n";
    }

}
