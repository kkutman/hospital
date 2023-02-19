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
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "departments")
    private List<Doctor>doctors;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "department")
    private List<Appointment> appointment;
}
