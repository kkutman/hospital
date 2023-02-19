package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.AppointmentDao;
import peaksoft.models.Appointment;
import peaksoft.services.AppointmentServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class AppointmentServicesImpl implements AppointmentServices {
    private final AppointmentDao appointmentDao;
    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentDao.saveAppointment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentDao.getAllAppointment();
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentDao.getAppointmentById(appointmentId);
    }

    @Override
    public void deleteAppointmentById(Long appointmentId) {
        appointmentDao.deleteAppointmentById(appointmentId);
    }

    @Override
    public void updateAppointmentId( Appointment appointment) {
        appointmentDao.updateAppointmentId(appointment.getId(),appointment);
    }
}
