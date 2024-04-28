package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.model.Location;

import java.util.List;

public interface LocationService {
    Location addNewLocation(Location location);
    List<Location> getAllLocation();
    Location getLocationById(Integer locationId);
    Location updateLocation(Location location);
    void deleteLocation(Integer locationId);
}
