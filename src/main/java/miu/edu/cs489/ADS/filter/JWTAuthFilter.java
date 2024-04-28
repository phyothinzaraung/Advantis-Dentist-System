package miu.edu.cs489.ADS.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import miu.edu.cs489.ADS.service.ADSUserDetailsService;
import miu.edu.cs489.ADS.service.util.JWTMgmtUtilityService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private ADSUserDetailsService adsUserDetailsService;

    public JWTAuthFilter(JWTMgmtUtilityService jwtMgmtUtilityService, ADSUserDetailsService adsUserDetailsService) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.adsUserDetailsService = adsUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String email = null;

        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            jwtToken = authorizationHeader.substring(7);
            email = jwtMgmtUtilityService.extractEmail(jwtToken);
        }
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = adsUserDetailsService.loadUserByUsername(email);
            if(jwtMgmtUtilityService.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
