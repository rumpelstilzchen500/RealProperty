package com.api.RealProperty.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String lastName;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String patroninic;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String login;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String password;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    @Size(min = 6, max = 15)
    private String phone;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "User_RealProperty",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "real_property_Id")})
    List<RealProperty> realProperties = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    public User(User users) {
        this.firstName = users.firstName;
        this.lastName = users.lastName;
        this.patroninic = users.patroninic;
        this.address = users.address;
        this.login = users.login;
        this.password = users.password;
        this.email = users.email;
        this.phone = users.phone;
        this.role = users.role;
    }


}