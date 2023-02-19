package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import peaksoft.dao.AppointmentDao;
import peaksoft.models.Appointment;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class AppointmentDaoImpl implements AppointmentDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveAppointment(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return entityManager.createQuery("select a from Appointment a", Appointment.class).getResultList();
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return entityManager.find(Appointment.class,appointmentId);
    }

    @Override
    public void deleteAppointmentById(Long appointmentId) {
        entityManager.remove(entityManager.find(Appointment.class,appointmentId));
    }


    @Override
    public void updateAppointmentId(Long appointmentId, Appointment appointment) {
        Appointment appointment1 = entityManager.find(Appointment.class, appointmentId);
        appointment1.setDate(appointment.getDate());
        appointment1.setPatient(appointment.getPatient());
        appointment1.setDoctor(appointment.getDoctor());
        appointment1.setDepartment(appointment.getDepartment());
        appointment1.setHospital(appointment.getHospital());
    }
}
