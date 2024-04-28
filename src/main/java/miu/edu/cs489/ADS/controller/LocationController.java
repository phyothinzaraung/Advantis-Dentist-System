package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.model.Location;
import miu.edu.cs489.ADS.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("api/ads/locations")
    private List<Location> getAllLocations(){
        return locationService.getAllLocation();
    }
}
