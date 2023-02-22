package com.totalplay.clubwifi.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "WIFI_CLUB_ADOPTION")
public class ClubwifiUsersAdoptionEntity implements Serializable {
    @Id
    @Column(name = "WCA_IDENTIFIER")
    private Long identifier;
    @Column(name = "WCA_USER")
    private String user;
    @Column(name = "WCA_CODE")
    private String code;
    @Column(name = "WCA_STATUS")
    private Long status;
    @Column(name = "WCA_CREATION_DATE")
    private LocalDateTime creationDate;
    @Column(name = "WCA_CANCELLATION_DATE")
    private LocalDateTime cancellationDate;
}
