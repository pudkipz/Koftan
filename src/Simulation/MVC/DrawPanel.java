package Simulation.MVC;

import Simulation.Vehicles.Vehicle;

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
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;

    // To keep track of a singel cars position
    private List<Point> points = new ArrayList();
    private Map<Point, Vehicle> pointBinder;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Vehicle vehicle){
        Vehicle currentVehicle = vehicle;
        if(x > 800-100){
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(800-100);
        }
        if(x < 0){
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(0);
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

    void initMap(List<Vehicle> vehicles){
        pointBinder = new HashMap<>();
        for (int i = 0; i < vehicles.size(); i++) {

            vehicles.get(i).setY(50 + 100*i);
            Point p = new Point((int) vehicles.get(i).getY(), (int) vehicles.get(i).getY());
            points.add(p);
            pointBinder.put(p, vehicles.get(i));
        }
    }


    private BufferedImage getCarImage(Vehicle vehicle) throws IOException {

        BufferedImage vehicleImage = null;

        switch (vehicle.getModelName()){

            case ("Volvo240"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
                break;

            case ("Saab95"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
                break;

            case ("Scania"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
                break;

                default:
                    break;

        }

        return vehicleImage;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < points.size(); i++) {

            Vehicle v = pointBinder.get(points.get(i));
            try {
                g.drawImage(getCarImage(v), (int) v.getX(), (int) v.getY(), null); // see javadoc for more info on the parameters
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}