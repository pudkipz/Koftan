package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.IBed;
import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Trucks.Flak.Trailer;

import java.awt.*;

/**
 * A truck of the model Mang90.
 */
public class MANG90 extends Truck implements IBed {
    
    private final Car[] cars = new Car[10];


    public MANG90(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "ManG90", nrDoors);
        bed = new Trailer(point);
        setBed(bed);
    }

    /**
     * @param c is the car to be loaded onto the load
     */
    public void load(Car c) {
        ((Trailer)bed).load(c);
    }

    /**
     * unloads the last car from the load
     *
     * @return the unloaded car
     */
    public Car unLoad() {
        return ((Trailer)(bed)).unLoad(((Trailer)(bed)).getLastCar());
    }

    /**
     * Turns the MANG90 and all loaded cars to the left
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnLeft();
        }
    }

    /**
     * Turns the MANG90 and all loaded cars to the right
     */
    @Override
    public void turnRight() {
        super.turnRight();
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnRight();
        }
    }

    /**
     * lowers the load
     */
    public void lowerLoad(double currentSpeed) {
        bed.lowerLoad(currentSpeed);
    }



    /**
     * raise the load
     */
    public void raiseLoad(double currentSpeed) {
        bed.raiseLoad(currentSpeed);
    }

    /**
     * moves the Simulation.Vehicles.Cars.Trucks.Truck and the loaded cars
     */
    @Override
    public void move() {

        super.move();
        ((Trailer)bed).moveAllChildren();

    }

    /**
     *
     * @return the bed of the MANG90
     */
    public IBed getbed() {
        return bed;
    }

}
