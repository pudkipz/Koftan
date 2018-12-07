package Simulation.Vehicles.Cars.Trucks.Flak;

import Simulation.Interfaces.IBed;
import Simulation.SwagPoint;
import javafx.geometry.Point2D;

import java.awt.*;

/**
 * A platform which can raise and lower its load. (Flak)
 */
public class Bed implements IBed {

    private double degrees = 0;
    private SwagPoint point;

    public Bed(SwagPoint point) {
        this.point = point;
    }

    /**
     * @return degrees of the load
     */
    public double getDegrees() {
        return degrees;
    }


    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public double getY() {
        return point.getY();
    }


    /**
     * Raise the load
     */
    public void raiseLoad(double currentSpeed) {
        if(currentSpeed == 0) {
            System.out.println("LoadRaised");
            if (degrees + 10 >= 70)
                degrees = 70;
            else
                degrees += 10;
        }
    }

    /**
     * Lower the load
     */
    public void lowerLoad(double currentSpeed) {
        if (currentSpeed == 0) {
            System.out.println("LoadLowered");
            if (degrees - 10 <= 0)
                degrees = 0;
            else
                degrees -= 10;

        }
    }
}
