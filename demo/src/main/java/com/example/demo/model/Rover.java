package com.example.demo.model;

public class Rover {
    private int x;
    private int y;
    
    // "N" -> North, "E" -> East, "S" -> South, "W" -> West
    private String direction;

    // Default constructor: Set the starting state
    public Rover() {
        // Initialize x and y to 0, and direction to "N"
        this.x = 0;
        this.y = 0;
        this.direction = "N";
    }

    // Parameterized constructor: Initialize with specific values
    public Rover(int x, int y, String direction) {
        // Store the incoming horizontal position
        this.x = x;

        // Store the incoming vertical position
        this.y = y;

        // Save the provided facing direction
        this.direction = direction;
    }

    // Setters and Getters

    public int getX() {
        // Return the current X value
        return this.x;
    }

    public void setX(int x) {
        // Update the internal X field
        this.x = x;
    }

    public int getY() {
        // Retrieve the current Y coordinate
        return this.y;
    }

    public void setY(int y) {
        // Update the internal Y field
        this.y = y;
    }

    public String getDirection() {
        // Provide the current cardinal direction
        return this.direction;
    }

    public void setDirection(String direction) {
        // Overwrite the old direction
        this.direction = direction;
    }
}