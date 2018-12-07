package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.IBed;
import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck implements Storeable {


    public Scania(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color,"Scania", nrDoors);
        bed = new Bed(point);
        setBed(bed);
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {

        bed.raiseLoad(getCurrentSpeed()); //TODO sätt till 1

    }

    /**
     * @return lower the load
     */
    public void lowerLoad() {
        bed.lowerLoad(getCurrentSpeed());
    }

    /**
     * Moves the scania.
     */
    @Override
    public void move() {
        super.move();
    }


    /**
     *
     * @return the bed of the Scania
     */
    public IBed getBed() {
        return bed;
    }

}
