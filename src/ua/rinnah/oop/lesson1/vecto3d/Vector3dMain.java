package ua.rinnah.oop.lesson1.vecto3d;

public class Vector3dMain {

    public static void main(String[] args) {

        //vector number one
        Vector3d vector1 = new Vector3d(2, 7 ,8);
        System.out.println(vector1 + "\r\n");


        //vector number two
        Vector3d vector2 = new Vector3d(5, 9 , 11);
        System.out.println(vector1 + "\r\n");

        //summ of vectors
        System.out.println("Summ of vectors: " + vector1.add(vector2) + "\r\n");

        //scalar product of vectors
        System.out.println("Scalar product of vectors: " + vector1.getScalarProd(vector2) + "\r\n");

        //vector product of vectors
        System.out.println("Vector product of vectors: " + vector1.getVectorProd(vector2) + "\r\n");

    }
}
