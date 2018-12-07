package Simulation.Interfaces;

public interface Storeable {
    boolean isLoaded();
    void setLoaded(boolean val);
    double getX();
    double getY();
    void setX(double x);
    void setY(double y);
}
