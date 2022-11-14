package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Role;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.UserEntity;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.dto.AuthResponseDTO;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.dto.LoginDto;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.dto.RegisterDto;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.RoleRepository;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.UserRepository;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.security.JWTGenerator;

import java.util.Collections;

@RestController
@RequestMapping("/players/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Nom usuari ja fet servir!", HttpStatus.BAD_REQUEST);
        }

        System.out.println("tenim usuari");
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        
        System.out.println("tenim password");
        Role roles = roleRepository.findByName("USER").get();
        System.out.println("tenim rol");
        
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("Usuari correcte!", HttpStatus.OK);
    }
}
