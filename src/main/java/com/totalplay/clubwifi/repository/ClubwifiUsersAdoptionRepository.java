package com.totalplay.clubwifi.repository;

import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import com.totalplay.clubwifi.entity.ClubwifiUsersAdoptionEntity;

@Repository
@Transactional
public interface ClubwifiUsersAdoptionRepository extends JpaRepository<ClubwifiUsersAdoptionEntity, Long> {

    @Query(value = "SELECT * FROM MICROWNER.WIFI_CLUB_ADOPTION WHERE WCA_USER = :user AND WCA_STATUS = :status", nativeQuery = true)
    ClubwifiUsersAdoptionEntity getUser(@Param("user") String user, @Param("status") Long status);

    @Query(value = "SELECT MAX(WCA_IDENTIFIER) FROM MICROWNER.WIFI_CLUB_ADOPTION", nativeQuery = true)
    Long getIdentifier();

    @Modifying
    @Query(value = "INSERT INTO MICROWNER.WIFI_CLUB_ADOPTION(WCA_IDENTIFIER, WCA_USER, WCA_CODE, WCA_EMAIL, WCA_STATUS, WCA_CREATION_DATE, WCA_CANCELLATION_DATE) VALUES(:identifier, :user, :code, :email, :status, :creationDate, :cancellationDate)", nativeQuery = true)
    void registerUser(@Param("identifier") Long identifier, @Param("user") String user, @Param("code") String code, @Param("email") String email, @Param("status") Long status, @Param("creationDate") LocalDateTime creationDate, @Param("cancellationDate") LocalDateTime cancellationDate);

}
