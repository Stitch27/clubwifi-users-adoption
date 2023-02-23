package com.totalplay.clubwifi.controller;

import org.springframework.http.ResponseEntity;
import com.totalplay.clubwifi.model.RequestRegisterModel;
import com.totalplay.clubwifi.model.ResponseRegisterModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.totalplay.clubwifi.service.ClubwifiUsersAdoptionService;

@RestController
@RequestMapping("/middleware")
public class ClubwifiUsersAdoptionController {

    @Autowired
    private ClubwifiUsersAdoptionService clubwifiUsersAdoptionService;

    @PostMapping("/clubwifi/adoption/users")
    public ResponseEntity<ResponseRegisterModel> register(@RequestBody(required = false)RequestRegisterModel requestRegisterModel){
        return clubwifiUsersAdoptionService.registerUser(requestRegisterModel);
    }

}
