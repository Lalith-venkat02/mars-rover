package com.example.demo.controller;

import com.example.demo.model.Rover;
import com.example.demo.service.RoverService;
import org.springframework.web.bind.annotation.*;

// Mark this class as a REST controller
@RestController

// Define the base URL path
@RequestMapping("/api")
public class RoverController {

    private final RoverService roverService;

    // Constructor Injection
    public RoverController(RoverService roverService) {

        // Store the injected service
        this.roverService = roverService;
    }

    // Endpoint: Get current status

    // HTTP GET method for retrieving data
    @GetMapping("/status")
    public Rover getStatus() {

        // Return current rover state
        return roverService.getRoverStatus();
    }

    // Endpoint: Send commands

    // HTTP POST method for sending commands
    @PostMapping("/move")
    public Rover moveRover(

        // Extract commands from query parameter
        @RequestParam String commands
    ) {

        // Execute commands
        return roverService.processCommands(commands);
    }

    // Endpoint: Reset

    // HTTP POST method for reset action
    @PostMapping("/reset")
    public Rover resetRover() {

        // Reset rover state
        return roverService.resetRover();
    }
}