package com.api.RealProperty.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "realProperty")
@Entity(name = "RealProperty")
public class RealProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long realPropertyId;

    @Column(nullable = false)
    String pricePerSquareMeter;

    @Column(nullable = false)
    String square;

    @Column(nullable = false)
    String conditionRealProperty;

    @Column(nullable = false)
    String area;

    @Column(nullable = false)
    String address;

    @ManyToMany(mappedBy = "realProperties")
    List<User> users = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "viewRealPropertyId", nullable = false)
    private ViewRealProperty viewRealPropertyId;
}
