package com.backend.Restro.services;

import com.backend.Restro.entity.UserDetail;
import com.backend.Restro.model.RegistrationRequest;
import com.backend.Restro.model.RegistrationUpdateRequest;
import com.backend.Restro.repository.BookingRepository;
import com.backend.Restro.repository.UserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserDetailRepository userDetailRepository;

    UserService(UserDetailRepository userDetailsRepository){
        this.userDetailRepository = userDetailsRepository;
    }

    public String createUserRegistration(RegistrationRequest request){
        log.info("Registration request {}", request);
        UserDetail userDetail = UserDetail.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();


        userDetailRepository.save(userDetail);

        return "User registered : "+userDetail.getName();
    }

    public String updateUserDetail(RegistrationUpdateRequest updateRequest){
        log.warn("Registration update request {}", updateRequest);

        UserDetail userDetail = userDetailRepository.findByName(updateRequest.getName());

        userDetail.setName(updateRequest.getName());
        userDetail.setPassword(updateRequest.getPassword());

        userDetailRepository.save(userDetail);

        return "User updated";
    }

    public String deleteUserDetail(String name){
        log.error("Delete user {}", name);
        log.debug("debug log");

        UserDetail userDetail = userDetailRepository.findByName(name);
        userDetailRepository.delete(userDetail);

        return "User deleted";
    }
}