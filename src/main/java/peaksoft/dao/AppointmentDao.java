package peaksoft.dao;

import peaksoft.models.Appointment;

import java.util.List;

/**
 * name : kutman
 **/
public interface AppointmentDao {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(Long appointmentId);
    void deleteAppointmentById(Long appointmentId);
    void updateAppointmentId(Long appointmentId,Appointment appointment);
}
