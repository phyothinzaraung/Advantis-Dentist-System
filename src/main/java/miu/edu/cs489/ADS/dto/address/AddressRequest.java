package miu.edu.cs489.ADS.dto.address;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipCode
) {
}
