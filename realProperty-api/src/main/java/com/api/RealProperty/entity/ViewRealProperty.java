package com.api.RealProperty.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ViewRealProperty")
@Table(name = "viewRealProperty")
public class ViewRealProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "view_real_id")
    private Long viewRealPropertyId;

    @Column(nullable = false, name = "view_real_name")
    private String name;
}
