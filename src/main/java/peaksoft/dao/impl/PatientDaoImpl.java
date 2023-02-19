package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.dao.PatientDao;
import peaksoft.models.Patient;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class PatientDaoImpl implements PatientDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void savePatient(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return entityManager.createQuery("select p from Patient p", Patient.class).getResultList();
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return entityManager.find(Patient.class,patientId);
    }

    @Override
    public void deletePatientById(Long patientId) {
        entityManager.remove(entityManager.find(Patient.class,patientId));
    }

    @Override
    public void updatePatientId(Long patientId, Patient patient) {
        Patient patient1 = entityManager.find(Patient.class, patientId);
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setGender(patient.getGender());
        patient1.setEmail(patient.getEmail());
        patient1.setHospital(patient.getHospital());
        patient1.setAppointments(patient.getAppointments());
    }
}
