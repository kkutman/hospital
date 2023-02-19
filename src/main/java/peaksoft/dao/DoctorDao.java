package peaksoft.dao;

import peaksoft.models.Doctor;

import java.util.List;

/**
 * name : kutman
 **/
public interface DoctorDao {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();
    Doctor getDoctorById(Long doctorId);
    void deleteDoctorById(Long doctorId);
    void updateDoctorId(Long doctorId,Doctor doctor);
}
