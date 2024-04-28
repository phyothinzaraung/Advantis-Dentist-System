package miu.edu.cs489.ADS.dto.patient;

import jakarta.validation.constraints.NotBlank;
import miu.edu.cs489.ADS.model.Address;

public record PatientRequest(
        @NotBlank(message = "First name is required and cannot be blank or null")
        String firstName,
        @NotBlank(message = "Last name is required and cannot be blank or null")
        String lastName,
        String email,
        String password,
        String phoneNumber,
        String dob,
        Address address
) {
}
