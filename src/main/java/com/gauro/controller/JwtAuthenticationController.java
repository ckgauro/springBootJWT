package com.gauro.controller;

import com.gauro.config.JwtTokenUtil;
import com.gauro.service.JwtUserDetailsService;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gauro.config.JwtTokenUtil;
import com.gauro.model.JwtRequest;
import com.gauro.model.JwtResponse;

/**
 * @author Chandra
 */
@Slf4j
@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        log.info("createAuthenticationToken========>10");
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        log.info("createAuthenticationToken========>20");
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        log.info("createAuthenticationToken========>30");
        log.info(userDetails.toString());
        log.info("createAuthenticationToken=userDetails=======>35");
        final String token = jwtTokenUtil.generateToken(userDetails);
        log.info("createAuthenticationToken========>40");
        JwtResponse tokendata=new JwtResponse(token);
       // return ResponseEntity.ok(new JwtResponse(token));
        log.info("createAuthenticationToken JwtResponse========>50");
        log.info(tokendata.toString());
        return ResponseEntity.ok(tokendata);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
