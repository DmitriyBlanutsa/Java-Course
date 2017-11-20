package ua.rinnah.oop.lesson1.vecto3d;

public class Vector3d {

    private double x;
    private double y;
    private double z;
    private double length;

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        salcLength();
    }

    public Vector3d() {
    }

    final void salcLength(){

        length =  Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3d add(Vector3d vector){

        return new Vector3d(x + vector.x, y + vector.y, z + vector.z);
    }

    public double getScalarProd(Vector3d vector){

        return x*vector.x + y*vector.y + z*vector.z;
    }

    public Vector3d getVectorProd(Vector3d vector){
        return new Vector3d(y*vector.z - z*vector.y, z*vector.x - x*vector.z, x*vector.y - y*vector.x);
    }

    @Override
    public String toString(){
        return String.format("Vector3d{Coordinate X: %.2f, Coordinate Y: %.2f, Coordinate Z: %.2f, Length: %.2f}",
                             x, y, z ,length);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
