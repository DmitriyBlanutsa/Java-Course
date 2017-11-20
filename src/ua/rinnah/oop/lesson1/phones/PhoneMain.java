package ua.rinnah.oop.lesson1.phones;

public class PhoneMain {

    public static void main(String[] args) {
        Network network = new Network();
        Phone.setNetwork(network);

        Phone myPhone = new Phone("+38(067)5110255","black","meizu");
        Phone mother = new Phone("0675111111");
        //incorrect format
        Phone dad = new Phone("06751102275");

        myPhone.registration();
        mother.registration();
        //subscriber without number
        dad.registration();

        //correct
        myPhone.call("0675111111");

        //correct
        myPhone.call(mother);
        Phone phone = new Phone("+38(067)2222222");

        //call to unregister subscriber
        myPhone.call(phone);
    }
}
