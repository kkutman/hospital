package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * name : kutman
 **/
@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    @ManyToMany
    private List<Department>departments;
    @OneToMany
    private List<Appointment>appointments;
    @ManyToOne
    private Hospital hospital;


}
