package ua.rinnah.oop.lesson3;

class SizeGroupExeption extends Exception{

    @Override
    public String getMessage() {
        return "Group if full!!!\r\n";
    }

}
