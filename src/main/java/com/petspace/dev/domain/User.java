package com.petspace.dev.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites = new ArrayList<>();

    @Column(length = 45)
    private String username;

    @Column(length = 45)
    private String nickname;

    @Column(length = 45)
    private String birth;

    @Column(length = 45, nullable = false)
    private String email;

    private String password;

    @ColumnDefault("1")
    private boolean privacyAgreement;

    private boolean marketingAgreement;

    @ColumnDefault("0")
    private boolean hostPermission;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @ColumnDefault("'NONE'")
    private OauthProvider oauthProvider;

    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false)
    @ColumnDefault("'ACTIVE'")
    private Status status;
}