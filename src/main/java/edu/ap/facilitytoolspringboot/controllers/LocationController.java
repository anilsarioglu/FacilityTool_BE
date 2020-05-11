package edu.ap.facilitytoolspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.ap.facilitytoolspringboot.models.Location;
import edu.ap.facilitytoolspringboot.services.LocationService;

@RestController
@CrossOrigin
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAll() {
        try {
            List<Location> locations = locationService.getAll();
            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations/by-name/{name}")
    public ResponseEntity<List<Location>> getByName(@PathVariable("name") String name) {
        try {
            List<Location> locations = locationService.getByName(name);
            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations/by-room/{room}")
    public ResponseEntity<Location> getByRoom(@PathVariable("room") String room) {
        try {
            Location location = locationService.getByRoom(room);
            if (location == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(location, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations/by-campus/{campus}")
    public ResponseEntity<List<Location>> getByCampus(@PathVariable("campus") String campus) {
        try {
            List<Location> locations = locationService.getByCampus(campus);
            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations/by-floor/{floor}")
    public ResponseEntity<List<Location>> getByFloor(@PathVariable("floor") int floor) {
        try {
            List<Location> locations = locationService.getByFloor(floor);
            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> postLocation(@RequestBody Location location) {
        try {
            Location loc = locationService.create(location);
            return new ResponseEntity<>(loc, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}