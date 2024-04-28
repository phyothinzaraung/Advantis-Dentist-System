package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.address.AddressResponse;
import miu.edu.cs489.ADS.model.Address;
import miu.edu.cs489.ADS.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addNewAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(address -> new AddressResponse(
                        address.getAddressId(),
                        address.getStreet(),
                        address.getCity(),
                        address.getState(),
                        address.getZipCode()
                )).toList();
    }

    @Override
    public Address getAddressById(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public Address updateAddress(Address address) {
        if (!addressRepository.existsById(address.getAddressId())) {
            throw new IllegalArgumentException("Address not found with id: " + address.getAddressId());
        }
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
