package miu.edu.cs489.ADS.dto.patient;

import miu.edu.cs489.ADS.dto.address.AddressResponse;

public record PatientResponse(
        Integer userId,
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        String dob,
        AddressResponse address
) {
}
