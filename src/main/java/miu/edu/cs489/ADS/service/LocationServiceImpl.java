package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.model.Location;
import miu.edu.cs489.ADS.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location addNewLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Integer locationId) {
        return locationRepository.findById(locationId).orElse(null);
    }

    @Override
    public Location updateLocation(Location location) {
        if(!locationRepository.existsById(location.getLocationId())){
            throw new IllegalArgumentException("Location not found with id: " + location.getLocationId());
        }
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Integer locationId) {
        locationRepository.deleteById(locationId);
    }
}
