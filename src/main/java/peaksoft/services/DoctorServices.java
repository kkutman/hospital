package peaksoft.services;

import peaksoft.models.Doctor;

import java.util.List;

/**
 * name : kutman
 **/
public interface DoctorServices {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();
    Doctor getDoctorById(Long doctorId);
    void deleteDoctorById(Long doctorId);
    void updateDoctorId(Doctor doctor);
}
