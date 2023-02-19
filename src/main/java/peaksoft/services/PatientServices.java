package peaksoft.services;

import peaksoft.models.Patient;

import java.util.List;

/**
 * name : kutman
 **/
public interface PatientServices {
    void savePatient(Patient patient);
    List<Patient> getAllPatient();
    Patient getPatientById(Long patientId);
    void deletePatientById(Long patientId);
    void updatePatientId(Patient patient);
}
