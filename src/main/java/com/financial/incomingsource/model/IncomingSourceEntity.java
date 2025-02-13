package com.financial.incomingsource.model;

import com.financial.incomingsource.enums.IncomingSourceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "insr_incomingsource")
public class IncomingSourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insr_id")
    private Integer id;

    @Column(name = "insr_name")
    private String name;

    @Column(name = "insr_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "insr_type")
    private IncomingSourceType type;

}
