package peaksoft.services;

import peaksoft.models.Appointment;

import java.util.List;

/**
 * name : kutman
 **/
public interface AppointmentServices {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(Long appointmentId);
    void deleteAppointmentById(Long appointmentId);
    void updateAppointmentId(Appointment appointment);
}
