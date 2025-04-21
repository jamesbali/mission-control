package com.bali.missioncontrol.model;

import com.bali.missioncontrol.model.enums.OrbitType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "satellites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Past
    @Column(name = "launch_date", nullable = false)
    private LocalDate launchDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "orbit_type", nullable = false)
    private OrbitType orbitType;

    @Column(name = "decommissioned", nullable = false)
    private boolean decommissioned;

    // Inverse side of many-to-many
    @ManyToMany(mappedBy = "satellites", fetch = FetchType.LAZY)
    private Set<Astronaut> astronauts;


}
