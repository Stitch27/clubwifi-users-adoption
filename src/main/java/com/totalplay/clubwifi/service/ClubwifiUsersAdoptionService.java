package com.totalplay.clubwifi.service;

import java.time.LocalDateTime;
import com.totalplay.clubwifi.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.totalplay.clubwifi.model.RequestRegisterModel;
import com.totalplay.clubwifi.model.ResponseRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.totalplay.clubwifi.entity.ClubwifiUsersAdoptionEntity;
import com.totalplay.clubwifi.repository.ClubwifiUsersAdoptionRepository;

@Service
public class ClubwifiUsersAdoptionService {

    @Autowired
    private ClubwifiUsersAdoptionRepository clubwifiUsersAdoptionRepository;

    public ResponseEntity<ResponseRegisterModel> registerUser(RequestRegisterModel requestRegisterModel){

        Long identifier;
        Result result = new Result();
        ResponseRegisterModel responseRegisterModel = new ResponseRegisterModel();
        ClubwifiUsersAdoptionEntity clubwifiUsersAdoptionEntity = new ClubwifiUsersAdoptionEntity();

        if(requestRegisterModel != null){

            try{

                if(!requestRegisterModel.getUser().trim().isEmpty()){

                    if(!requestRegisterModel.getCode().trim().isEmpty()){

                        if(!requestRegisterModel.getEmail().trim().isEmpty()){

                            if(!requestRegisterModel.getStatus().trim().isEmpty()){

                                try{

                                    clubwifiUsersAdoptionEntity = clubwifiUsersAdoptionRepository.getUser(requestRegisterModel.getUser().trim(), Long.parseLong(requestRegisterModel.getStatus().trim()));

                                }catch(Exception e){

                                    result.setCode("-51");
                                    result.setDescription("No fue posible obtener la información del usuario.");
                                    responseRegisterModel.setResult(result);

                                    return new ResponseEntity<>(responseRegisterModel, HttpStatus.NOT_FOUND);

                                }

                                if(clubwifiUsersAdoptionEntity == null){

                                    try{

                                        identifier = getIndentifier();

                                    }catch(Exception e){

                                        result.setCode("-52");
                                        result.setDescription("No fue posible calcular el identificador.");
                                        responseRegisterModel.setResult(result);

                                        return new ResponseEntity<>(responseRegisterModel, HttpStatus.NOT_FOUND);

                                    }

                                    if(identifier != null){

                                        identifier ++;
                                        LocalDateTime date = LocalDateTime.now();

                                        try{

                                            clubwifiUsersAdoptionRepository.registerUser(identifier, requestRegisterModel.getUser(), requestRegisterModel.getCode(),
                                                    requestRegisterModel.getEmail().trim(), Long.parseLong(requestRegisterModel.getStatus().trim()), date, date);

                                            result.setCode("100");
                                            result.setDescription("Petición realizada con éxito.");
                                            responseRegisterModel.setResult(result);

                                            return new ResponseEntity<>(responseRegisterModel, HttpStatus.ACCEPTED);

                                        }catch(Exception e){

                                            result.setCode("-53");
                                            result.setDescription("No fue posible realizar el registro del usuario.");
                                            responseRegisterModel.setResult(result);

                                            return new ResponseEntity<>(responseRegisterModel, HttpStatus.NOT_FOUND);

                                        }

                                    }else{

                                        identifier = 1L;
                                        LocalDateTime date = LocalDateTime.now();

                                        try{

                                            clubwifiUsersAdoptionRepository.registerUser(identifier, requestRegisterModel.getUser(), requestRegisterModel.getCode(),
                                                    requestRegisterModel.getEmail().trim(), Long.parseLong(requestRegisterModel.getStatus().trim()), date, date);

                                            result.setCode("100");
                                            result.setDescription("Petición realizada con éxito.");
                                            responseRegisterModel.setResult(result);

                                            return new ResponseEntity<>(responseRegisterModel, HttpStatus.ACCEPTED);

                                        }catch(Exception e){

                                            result.setCode("-53");
                                            result.setDescription("No fue posible realizar el registro del usuario.");
                                            responseRegisterModel.setResult(result);

                                            return new ResponseEntity<>(responseRegisterModel, HttpStatus.NOT_FOUND);

                                        }

                                    }

                                }else{

                                    result.setCode("700");
                                    result.setDescription("Usuario ya registrado.");
                                    responseRegisterModel.setResult(result);

                                    return new ResponseEntity<>(responseRegisterModel, HttpStatus.ACCEPTED);

                                }

                            }else{

                                result.setCode("600");
                                result.setDescription("Ingresar estatus.");
                                responseRegisterModel.setResult(result);

                                return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);

                            }

                        }else{

                            result.setCode("500");
                            result.setDescription("Ingresar correo electrónico.");
                            responseRegisterModel.setResult(result);

                            return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);

                        }

                    }else{

                        result.setCode("400");
                        result.setDescription("Ingresar código.");
                        responseRegisterModel.setResult(result);

                        return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);

                    }

                }else{

                    result.setCode("300");
                    result.setDescription("Ingresar usuario.");
                    responseRegisterModel.setResult(result);

                    return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);

                }

            }catch(Exception e){

                result.setCode("-50");
                result.setDescription("Solicitud incorrecta.");
                responseRegisterModel.setResult(result);

                return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);

            }

        }else{

            result.setCode("200");
            result.setDescription("Solicitud vacía.");
            responseRegisterModel.setResult(result);

            return new ResponseEntity<>(responseRegisterModel, HttpStatus.BAD_REQUEST);
        }

    }


    private Long getIndentifier(){

        return clubwifiUsersAdoptionRepository.getIdentifier();

    }

}
