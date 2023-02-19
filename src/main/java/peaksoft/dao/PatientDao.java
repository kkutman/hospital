package peaksoft.dao;

import peaksoft.models.Patient;

import java.util.List;

/**
 * name : kutman
 **/
public interface PatientDao {
    void savePatient(Patient patient);
    List<Patient> getAllPatient();
    Patient getPatientById(Long patientId);
    void deletePatientById(Long patientId);
    void updatePatientId(Long patientId,Patient patient);
}
