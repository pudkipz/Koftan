package Simulation.MVC;

import Simulation.SwagPoint;
import Simulation.Vehicles.Cars.Car;
import javafx.geometry.Point2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    List<SwagPoint> points = new ArrayList();
    Map<SwagPoint, Car> pointBinder;

    private Car currentCar;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Car car){
        currentCar = car;
        if(x > 800-100){
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
            car.setX(800-100);
        }
        if(x < 0){
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
            car.setX(0);
        }


    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string

            volvoImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void initMap(List<Car> cars){
        pointBinder = new HashMap<>();
        for (int i = 0; i < cars.size(); i++) {

            cars.get(i).setY(50 + 100*i);
            points.add(cars.get(i).point);
            pointBinder.put(cars.get(i).point, cars.get(i));
        }
    }


    private BufferedImage getCarImage(Car car) throws IOException {

        BufferedImage carImage = null;

        switch (car.getModelName()){

            case ("Volvo240"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
                break;

            case ("Saab95"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
                break;

            case ("Scania"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
                break;

                default:
                    break;

        }

        return carImage;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < points.size(); i++) {

            Car c = pointBinder.get(points.get(i));
            try {
                g.drawImage(getCarImage(c), (int) c.getX(), (int) c.getY(), null); // see javadoc for more info on the parameters
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}