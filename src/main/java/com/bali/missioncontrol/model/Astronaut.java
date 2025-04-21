package com.bali.missioncontrol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "astronauts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Min(0)
    @Max(50)
    @Column(name = "experience_years", nullable = false)
    private int experienceYears;

    // Owning side of many-to-many relationship
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "astronaut_satellite",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private Set<Satellite> satellites;

}
