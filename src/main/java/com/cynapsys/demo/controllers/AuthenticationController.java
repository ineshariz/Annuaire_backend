package com.cynapsys.demo.controllers;

import com.cynapsys.demo.conf.JwtTokenUtil;
import com.cynapsys.demo.models.AuthToken;
import com.cynapsys.demo.models.LoginUser;
import com.cynapsys.demo.models.User;
import com.cynapsys.demo.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "token/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	System.out.println(loginUser.getUsername());
    	System.out.println(loginUser.getPassword());

          final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Optional<User> user = userService.findByEmail(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user.get());
        System.out.println(token);
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    @RequestMapping(value="/check", method = RequestMethod.GET)
    public ResponseEntity test() {
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<User> getList(){
    	return userService.getListUser();
    	
    }

}
