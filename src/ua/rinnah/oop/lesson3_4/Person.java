package ua.rinnah.oop.lesson3_4;

public class Person {

    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;

    public Person(String firstname, String lastname, int age, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        ageValidation(age);
        this.gender = gender;
    }

    public Person() {
    }

    final private void ageValidation(int age){
        try{
            if (age < 0)
               throw new IllegalArgumentException("age is less than zero");
            this.age = age;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Person{firstname=%s, lastname=%s, age=%d, gender=%s}", firstname, lastname, age, gender);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender(){
        return gender;
    }
}


