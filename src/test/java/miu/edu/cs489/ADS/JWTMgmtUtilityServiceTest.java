package miu.edu.cs489.ADS;


import io.jsonwebtoken.Claims;
import miu.edu.cs489.ADS.service.util.JWTMgmtUtilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class JWTMgmtUtilityServiceTest {

    @InjectMocks
    private JWTMgmtUtilityService jwtMgmtUtilityService;

    @Mock
    UserDetails mockUserDetails;

    private String token;
    private String username = "test@example.com";

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "USER");
        token = jwtMgmtUtilityService.createToken(claims, username);
        when(mockUserDetails.getUsername()).thenReturn(username);
    }

    @Test
    public void testExtractExpiration() {
        Date expiration = jwtMgmtUtilityService.extractExpiration(token);
        assertNotNull(expiration);
    }

    @Test
    public void testExtractClaim(){
        Claims claims = jwtMgmtUtilityService.extractAllClaims(token);
        assertEquals(username, claims.getSubject());
        assertEquals("USER", claims.get("role"));
    }

    @Test
    public void testCreateToken(){
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    public void testGenerateToken(){
        String generateToken = jwtMgmtUtilityService.generateToken(username);
        assertNotNull(generateToken);
        assertFalse(generateToken.isEmpty());
    }

    @Test
    public void testIsTokenExpired(){
        assertFalse(jwtMgmtUtilityService.isTokenExpired(token));
    }

    @Test
    public void testValidToken(){
        assertTrue(jwtMgmtUtilityService.validateToken(token, mockUserDetails));
    }
}
