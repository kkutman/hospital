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
@Table(name = "hospital")
@NoArgsConstructor
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String img;
    @OneToMany(mappedBy = "hospital")
    private  List<Doctor>doctors;
    @OneToMany(mappedBy = "hospital")
    private  List<Patient>patients;
    @OneToMany(mappedBy = "hospital")
    private  List<Department>departments;
    @OneToMany(mappedBy = "hospital")
    private  List<Appointment>appointments;

}
