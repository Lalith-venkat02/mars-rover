package com.example.demo.service;

import com.example.demo.model.Rover;
import org.springframework.stereotype.Service;

// Annotate this class to indicate it holds the business logic
@Service
public class RoverService {

    private final Rover rover;

    // Initialize the Rover when the service starts
    public RoverService() {
        // Instantiate the 'rover' object so it's not null
        this.rover = new Rover();
    }

    // Processes a string of commands (e.g., "FFRFFL")
    public Rover processCommands(String commands) {

        // Iterate over each character in the command string
        for (char command : commands.toUpperCase().toCharArray()) {

            if (command == 'L') {
                // Turn the rover left
                turnLeft();

            } else if (command == 'R') {
                // Turn the rover right
                turnRight();

            } else if (command == 'F') {
                // Move the rover forward
                moveForward();
            }
        }

        return rover;
    }

    // Retrieve the current status of the rover
    public Rover getRoverStatus() {
        return rover;
    }

    // Reset rover to starting position
    public Rover resetRover() {

        // Reset X and Y to origin (0,0)
        rover.setX(0);
        rover.setY(0);

        // Reset direction to North
        rover.setDirection("N");

        return rover;
    }

    // Logic Methods

    private void turnLeft() {

        // Update direction based on LEFT turn
        switch (rover.getDirection()) {

            case "N":
                rover.setDirection("W"); // North -> West
                break;

            case "W":
                rover.setDirection("S"); // West -> South
                break;

            case "S":
                rover.setDirection("E"); // South -> East
                break;

            case "E":
                rover.setDirection("N"); // East -> North
                break;
        }
    }

    private void turnRight() {

        // Update direction based on RIGHT turn
        switch (rover.getDirection()) {

            case "N":
                rover.setDirection("E"); // North -> East
                break;

            case "E":
                rover.setDirection("S"); // East -> South
                break;

            case "S":
                rover.setDirection("W"); // South -> West
                break;

            case "W":
                rover.setDirection("N"); // West -> North
                break;
        }
    }

    private void moveForward() {

        int currentX = rover.getX();
        int currentY = rover.getY();

        switch (rover.getDirection()) {

            case "N":

                // Move up on Y-axis
                if (currentY < 9) {
                    rover.setY(currentY + 1);
                }
                break;

            case "S":

                // Move down on Y-axis
                if (currentY > 0) {
                    rover.setY(currentY - 1);
                }
                break;

            case "E":

                // Move right on X-axis
                if (currentX < 9) {
                    rover.setX(currentX + 1);
                }
                break;

            case "W":

                // Move left on X-axis
                if (currentX > 0) {
                    rover.setX(currentX - 1);
                }
                break;
        }
    }
}