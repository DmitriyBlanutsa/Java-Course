package ua.rinnah.oop.lesson1.phones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    private String number;
    private String color;
    private String model;
    private static Network network;

    public Phone(String number, String color, String model) {
        if (isValid(number))
            this.number = number;
        else
            System.out.println("Number is not valid!!!");
        this.color = color;
        this.model = model;
    }

    public Phone(String number) {
        if (isValid(number))
            this.number = number;
        else
            System.out.println("Number is not valid!!!");
    }

    public void addPhone(){
        if (number != null) {
            number = number.replace("+38", "")
                    .replace("-", "")
                    .replace("(", "")
                    .replace(")", "");
            network.getSubscribers().add(number);
        }else
            System.out.println("Error!!!Add number!!!");
    }


    public void call(String number){
        if (network.getSubscribers().contains(number))
            System.out.println("Call to " + number);
        else
            System.out.println("Error!!! This number does not exist!!!");
    }

    public void call(Phone phone){
        if (network.getSubscribers().contains(phone.getNumber()))
            System.out.println("Call to " + phone.getNumber());
        else
            System.out.println("Error!!! This number does not exist!!!");
    }

    /*supporting format:
    +380XXXXXXXXX
    +38(0XX)XXXXXXX
    0XXXXXXXXX
    (0XX)XXXXXXX
    */
    final private boolean isValid(String number){
        Pattern p = Pattern.compile("^(\\+38)?\\(?[0][1-9]\\d\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static Network getNetwork() {
        return network;
    }

    public static void setNetwork(Network network) {
        Phone.network = network;
    }
}
