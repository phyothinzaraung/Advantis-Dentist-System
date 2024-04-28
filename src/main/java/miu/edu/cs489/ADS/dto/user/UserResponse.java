package miu.edu.cs489.ADS.dto.user;

import miu.edu.cs489.ADS.dto.address.AddressResponse;

public record UserResponse(
        Integer userId,
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        AddressResponse address
) {
}