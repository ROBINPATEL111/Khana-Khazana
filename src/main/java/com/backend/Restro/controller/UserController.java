package com.backend.Restro.controller;
import com.backend.Restro.model.RegistrationRequest;
import com.backend.Restro.model.RegistrationUpdateRequest;
import com.backend.Restro.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {



    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/test")
    public ResponseEntity<String> getUserDetail(){
        return new ResponseEntity<>("This is a sample API response for user details", HttpStatus.ACCEPTED);
    }


    @GetMapping("/test/{ownerName}")
    public ResponseEntity<String> getUserDetailFromPath(@PathVariable(name = "ownerName") String name){
        return new ResponseEntity<>("This is a sample API response for " + name, HttpStatus.ACCEPTED);
    }


    @GetMapping("/test/{ownerName}/param")
    public ResponseEntity<String> getUserDetailFromParams(@PathVariable(name = "ownerName") String name, @RequestParam("surname") String paramValue){
        return new ResponseEntity<>("This is a sample API response for " + name + paramValue, HttpStatus.ACCEPTED);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUserRegistration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(this.userService.createUserRegistration(registrationRequest), HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateUserRegistration(@RequestBody RegistrationUpdateRequest registrationUpdateRequest){
        return new ResponseEntity<>(this.userService.updateUserDetail(registrationUpdateRequest), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteUserRegistration(@PathVariable String name){
        return new ResponseEntity<>(this.userService.deleteUserDetail(name), HttpStatus.OK);
    }




}