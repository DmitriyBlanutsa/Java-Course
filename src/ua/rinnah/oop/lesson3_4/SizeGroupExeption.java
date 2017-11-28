package ua.rinnah.oop.lesson3_4;

class SizeGroupExeption extends Exception{

    @Override
    public String getMessage() {
        return "Group if full!!!\r\n";
    }

}
