package Simulation.Interfaces;

import Simulation.Vehicles.Cars.Car;

public interface IBed {
    Car[] cars = new Car[10];
    //TODO Klura ut varför och hur? Yolo man-
    // Simulation.Vehicles.Cars.Trucks.Flak.Bed bed = null;



    /**
     * Get x-position of the object.
     * @return
     */
    double getX();
    /**
     * Get y-position of the object.
     * @return
     */
    double getY();

    /**
     * Raises the load.
     */
    void raiseLoad(double currentSpeed);

    /**
     * Lowers the load.
     */
    void lowerLoad(double currentSpeed);


    /**
     *
     * @return the current degree of the tilt of the load
     */
    double getDegrees();

}
