package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.dao.DoctorDao;
import peaksoft.models.Doctor;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class DoctorDaoImpl implements DoctorDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveDoctor(Doctor doctor) {
        entityManager.persist(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return entityManager.createQuery("select d from Doctor d", Doctor.class).getResultList();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return entityManager.find(Doctor.class,doctorId);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        entityManager.find(Doctor.class,entityManager.find(Doctor.class,doctorId));
    }

    @Override
    public void updateDoctorId(Long doctorId, Doctor doctor) {
        Doctor doctor1 = entityManager.find(Doctor.class, doctorId);
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setPosition(doctor.getPosition());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setDepartments(doctor.getDepartments());
        doctor1.setAppointments(doctor.getAppointments());
        doctor1.setHospital(doctor.getHospital());
    }
}
