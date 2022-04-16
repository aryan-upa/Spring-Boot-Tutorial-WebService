package com.example.springboot.mobileappws.Security;

import com.example.springboot.mobileappws.SpringApplicationContext;
import com.example.springboot.mobileappws.service.UserService;
import com.example.springboot.mobileappws.shared.dto.UserDto;
import com.example.springboot.mobileappws.ui.model.request.UserLoginRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.springboot.mobileappws.Security.SecurityConstants.HEADER_STRING;
import static com.example.springboot.mobileappws.Security.SecurityConstants.TOKEN_PREFIX;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication
            (HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UserLoginRequestModel credentials =
                    new ObjectMapper()
                            .readValue(request.getInputStream(), UserLoginRequestModel.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>()
                    )
            );

        }
        catch (IOException e) {
            throw new RuntimeException("Failed Authentication!!");
        }
    }

    protected void successfulAuthentication
            (HttpServletRequest request,
             HttpServletResponse response,
             FilterChain filterChain,
             Authentication auth) {

        String userName = ( (User) auth.getPrincipal() ).getUsername();

        // JSON Web Token
        String token = Jwts
                        .builder()
                        .setSubject(userName)
                        .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                        .compact();

        UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
        UserDto userDto = userService.getUser(userName);

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        response.addHeader("UserID", userDto.getUserId());
    }

}
