package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.address.AddressResponse;
import miu.edu.cs489.ADS.model.Address;

import java.util.List;

public interface AddressService {

    Address addNewAddress(Address address);
    List<AddressResponse> getAllAddress();
    Address getAddressById(Integer addressId);
    Address updateAddress(Address address);
    void deleteAddress(Integer addressId);
}
