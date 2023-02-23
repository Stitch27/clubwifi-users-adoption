package com.totalplay.clubwifi.model;

import lombok.Data;

@Data
public class RequestRegisterModel {

    private String user;
    private String code;
    private String email;
    private String status;
}
