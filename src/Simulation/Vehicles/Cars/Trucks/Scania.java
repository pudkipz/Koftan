package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck implements Storeable {


    private Bed bed = new Bed(this);


    public Scania(double enginePower, double currentSpeed, Color color) {
        super(enginePower, currentSpeed, color,"Scania");
        setBed(bed);
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {

        bed.raiseLoad(10); //TODO sätt till 1

    }

    /**
     * @return lower the load
     */
    public void lowerLoad() {
        bed.lowerLoad(10);
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
    public Bed getBed() {
        return bed;
    }

}
