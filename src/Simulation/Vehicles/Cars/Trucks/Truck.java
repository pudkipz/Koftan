package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.IBed;
import Simulation.Vehicles.Cars.Car;

import java.awt.*;

/**
 * A type of car that has a bed.
 */
public abstract class Truck extends Car  {

    protected IBed bed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);


    }

    /**
     *
     * @return speedfactor of the truck.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Starts engine
     */
    @Override
    public void startEngine(){
        if(bed.getDegrees() == 70){
            super.startEngine();
        }
    }

    /**
     * Accelerates the truck as long as degrees of its bed is not zero.
     * @param amount
     */
    @Override
    public void gas(double amount) {
        if(bed.getDegrees() == 70) {
            super.gas(amount);
        }
    }

    /**
     * sets the instance of the bed.
     * @param bed sets local instance of bed to its value.
     */
    public void setBed(IBed bed) {
        this.bed = bed;
    }

    public IBed getBed(){
        return bed;
    }

    /**
     * @return the current degree of the tilt of the load
     */
    public double getDegrees() {
        return bed.getDegrees();
    }



}
