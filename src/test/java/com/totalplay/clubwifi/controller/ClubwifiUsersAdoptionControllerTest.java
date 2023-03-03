package com.totalplay.clubwifi.controller;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.totalplay.clubwifi.entity.ClubwifiUsersAdoptionEntity;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.totalplay.clubwifi.repository.ClubwifiUsersAdoptionRepository;

@DataJpaTest
@ActiveProfiles("test")
class ClubwifiUsersAdoptionControllerTest {

    @Autowired
    private ClubwifiUsersAdoptionRepository clubwifiUsersAdoptionRepository;

    @Test
    public void register() {

        LocalDateTime date = LocalDateTime.now();

        ClubwifiUsersAdoptionEntity clubwifiUsersAdoptionEntity = new ClubwifiUsersAdoptionEntity();

        clubwifiUsersAdoptionEntity.setIdentifier(Long.valueOf(1));
        clubwifiUsersAdoptionEntity.setUser("5631159899");
        clubwifiUsersAdoptionEntity.setCode("aaron.027");
        clubwifiUsersAdoptionEntity.setEmail("hdz.aaron.27");
        clubwifiUsersAdoptionEntity.setStatus(1l);
        clubwifiUsersAdoptionEntity.setCreationDate(date);
        clubwifiUsersAdoptionEntity.setCancellationDate(date);

        ClubwifiUsersAdoptionEntity user = clubwifiUsersAdoptionRepository.save(clubwifiUsersAdoptionEntity);

        Assertions.assertEquals(user.getUser(), "5631159899");

    }


}