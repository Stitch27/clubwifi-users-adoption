package com.totalplay.clubwifi.repository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import com.totalplay.clubwifi.entity.ClubwifiUsersAdoptionEntity;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface ClubwifiUsersAdoptionRepository extends JpaRepository<ClubwifiUsersAdoptionEntity, Long> {

    @Query(value = "SELECT * FROM TPBANKOWNER.WIFI_CLUB_ADOPTION WHERE WCA_USER = :user AND WCA_CODE = 1", nativeQuery = true)
    ClubwifiUsersAdoptionEntity getUser(@Param("user") String user);

    @Query(value = "SELECT MAX(WCA_IDENTIFIER) FROM TPBANKOWNER.WIFI_CLUB_ADOPTION", nativeQuery = true)
    Long getIdentifier();

    @Modifying
    @Query(value = "INSERT INTO TPBANKOWNER.WIFI_CLUB_ADOPTION(WCA_IDENTIFIER, WCA_USER, WCA_CODE, WCA_STATUS, WCA_CREATION_DATE, WCA_CANCELLATION_DATE) VALUES(:identifier, :user, :code, :status, :creationDate, :cancellationDate)", nativeQuery = true)
    void registerUser(@Param("identifier") Long identifier, @Param("user") String user, @Param("code") String code, @Param("status") Long status, @Param("creationDate") LocalDateTime creationDate, @Param("cancellationDate") LocalDateTime cancellationDate);

}
