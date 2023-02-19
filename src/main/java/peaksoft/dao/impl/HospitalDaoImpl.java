package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.dao.HospitalDao;
import peaksoft.models.Hospital;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class HospitalDaoImpl implements HospitalDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return entityManager.createQuery("select h from Hospital  h", Hospital.class).getResultList();
    }

    @Override
    public Hospital getHospitalById(Long hospitalId) {
        return entityManager.find(Hospital.class,hospitalId);
    }

    @Override
    public void deleteHospitalById(Long hospitalId) {
        entityManager.remove(entityManager.find(Hospital.class,hospitalId));
    }

    @Override
    public void updateHospitalId(Long hospitalId,Hospital hospital) {
        Hospital hospital1 = entityManager.find(Hospital.class, hospitalId);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
//        hospital1.setDoctors(hospital.getDoctors());
//        hospital1.setPatients(hospital.getPatients());
//        hospital1.setDepartments(hospital.getDepartments());
//        hospital1.setAppointments(hospital.getAppointments());
    }
}
