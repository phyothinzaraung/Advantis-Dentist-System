package miu.edu.cs489.ADS.dto.userAuth;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
