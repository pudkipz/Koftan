package Simulation.Vehicles.Cars.Trucks.Flak;

import Simulation.Interfaces.IBed;
import Simulation.Interfaces.Storeable;
import Simulation.SwagPoint;
import Simulation.Vehicles.Cars.Car;
import javafx.geometry.Point2D;

import java.awt.*;

/**
 * A type of bed which can load cars.
 */
public class Trailer implements IBed {
    private Car[] cars = new Car[10];
    private Bed bed;

    public Trailer(SwagPoint point) {
        this.bed = new Bed(point);
    }

    /**
     * loads a car to the truck
     * @param c the car to be loaded
     */
    public void load(Car c) {

        if (c instanceof Storeable && isClose(c) && bed.getDegrees() == 0 && !c.isLoaded()) {
            addCar(c);
            c.setLoaded(true);
        }

    }

    /**
     * Moves all the loaded cars to the same coordinates as the trailer.
     */
    public void moveAllChildren() {
        for (int i = 0; i < bed.cars.length; i++) {
            if(cars[i] != null){
                cars[i].setX(bed.getX());
                cars[i].setY(bed.getY());
            }

        }
    }

    /**
     * unloads a car
     *
     * @return the offloaded car
     */
    public Car unLoad(Car c) {
        if (bed.getDegrees() == 0) {
            int index = 0;

            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == c) {
                    index = i;
                    cars[i] = null;
                    break;
                }
            }

            shiftArrLeft(cars, index);
            c.setLoaded(false);
            return c;
        }
        return null;
    }

    /**
     *
     * @param c the car to check the distance to
     * @return wether or not the given car is close enough to be loaded
     */
    private boolean isClose(Car c) {
        if (c.getX() - bed.getX() <= 10 && c.getX() - bed.getX() >= -10) {
            if (c.getY() - bed.getY() <= 10 && c.getY() - bed.getY() >= -10) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the cars loaded on the trailer
     */
    public Car[] getCars() {
        return cars;
    }


    /**
     * Adds a car to the load
     *
     * @param c is the car to be loaded
     */
    private void addCar(Car c) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = c;
                c.setX(bed.getX());
                c.setY(bed.getY());
                return;
            }
        }

    }

    /**
     * Shifts the given array as far to the right as possible
     * @param cars the array to be shifted
     * @param index
     */
    private void shiftArrLeft(Car[] cars, int index) {

        for (int i = index + 1; i < cars.length; i++) {
            cars[i - 1] = cars[i];
        }
        cars[cars.length - 1] = null;

    }

    /**
     * @return the first car in load
     */
    public Car getFirstCar() {
        return cars[0];
    }

    /**
     * @return the last car in load
     */
    public Car getLastCar() {
        Car car = null;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                car = cars[i];
            }
        }
        return car;
    }

    @Override
    public double getX() {
        return bed.getX();
    }

    @Override
    public double getY() {
        return bed.getY();
    }

    @Override
    public void raiseLoad(double currentSpeed) {
        bed.raiseLoad(currentSpeed);
    }

    @Override
    public void lowerLoad(double currentSpeed) {
        bed.lowerLoad(currentSpeed);
    }

    @Override
    public double getDegrees() {
        return bed.getDegrees();
    }
}
