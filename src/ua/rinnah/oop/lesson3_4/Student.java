package ua.rinnah.oop.lesson3_4;

public class Student extends Person{

    private String university;
    private String faculty;
    private String specialty;
    private double averegeScore;

    public Student(String firstname, String lastname, int age, Gender gender, String university, String faculty, String specialty, double averegeScore) {
        super(firstname, lastname, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        scoreValidation(averegeScore);
    }

    public Student(Person person,String university, String faculty, String specialty, double averegeScore){
        super(person.getFirstname(), person.getLastname(), person.getAge(), person.getGender());
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        scoreValidation(averegeScore);
    }

    public Student(){
        super();
    }



    final private void scoreValidation(double averegeScore){
        try{
            if (averegeScore < 0)
                throw new IllegalArgumentException("score is less than zero");
            this.averegeScore = averegeScore;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Student{%s\r\n" +
                "university=%s, faculty=%s, specialty=%s, averegeScore=%s}", super.toString(), university, faculty, specialty, averegeScore);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getAveregeScore() {
        return averegeScore;
    }

    public void setAveregeScore(double averegeScore) {
        this.averegeScore = averegeScore;
    }
}
