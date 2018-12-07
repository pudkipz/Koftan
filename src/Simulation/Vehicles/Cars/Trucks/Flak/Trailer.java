package Simulation.Vehicles.Cars.Trucks.Flak;

import Simulation.Interfaces.Loadable;
import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Car;

/**
 * A type of bed which can load storeables.
 */
public class Trailer extends Bed {
    private Storeable[] storeables = new Car[10];
    private Loadable owner;

    public Trailer(Loadable owner) {
        super(owner);
        this.owner = owner;
    }

    /**
     * loads a car to the truck
     * @param s the Storeable to be loaded
     */
    public void load(Storeable s) {

        if (s instanceof Storeable && isClose(s) && getDegrees() == 0 && !s.isLoaded()) {
            addCar(s);
            s.setLoaded(true);
        }

    }

    /**
     * Moves all the loaded storeables to the same coordinates as the trailer.
     */
    public void moveAllChildren() {
        for (int i = 0; i < owner.cars.length; i++) {
            if(storeables[i] != null){
                storeables[i].setX(owner.getX());
                storeables[i].setY(owner.getY());
            }

        }
    }

    /**
     * unloads a car
     *
     * @return the offloaded car
     */
    public Storeable unLoad(Storeable s) {
        if (getDegrees() == 0) {
            int index = 0;

            for (int i = 0; i < storeables.length; i++) {
                if (storeables[i] == s) {
                    index = i;
                    storeables[i] = null;
                    break;
                }
            }

            shiftArrLeft(storeables, index);
            s.setLoaded(false);
            return s;
        }
        return null;
    }

    /**
     *
     * @param s the car to check the distance to
     * @return wether or not the given car is close enough to be loaded
     */
    private boolean isClose(Storeable s) {
        if (s.getX() - owner.getX() <= 10 && s.getX() - owner.getX() >= -10) {
            if (s.getY() - owner.getY() <= 10 && s.getY() - owner.getY() >= -10) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the storeables loaded on the trailer
     */
    public Storeable[] getCars() {
        return storeables;
    }


    /**
     * Adds a car to the load
     *
     * @param s is the car to be loaded
     */
    private void addCar(Storeable s) {

        for (int i = 0; i < storeables.length; i++) {
            if (storeables[i] == null) {
                storeables[i] = s;
                s.setX(owner.getX());
                s.setY(owner.getY());
                return;
            }
        }
    }

    /**
     * Shifts the given array as far to the right as possible
     * @param storeables the array to be shifted
     * @param index
     */
    private void shiftArrLeft(Storeable[] storeables, int index) {

        for (int i = index + 1; i < storeables.length; i++) {
            storeables[i - 1] = storeables[i];
        }
        storeables[storeables.length - 1] = null;

    }

    /**
     * @return the first car in load
     */
    public Storeable getFirstCar() {
        return storeables[0];
    }

    /**
     * @return the last car in load
     */
    public Storeable getLastCar() {
        Storeable storeable = null;
        for (int i = 0; i < storeables.length; i++) {
            if (storeables[i] != null) {
                storeable = storeables[i];
            }
        }
        return storeable;
    }

}
