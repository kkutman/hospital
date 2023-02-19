package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.DoctorDao;
import peaksoft.models.Doctor;
import peaksoft.services.DoctorServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class DoctorServicesImpl implements DoctorServices {
    private final DoctorDao doctorDao;
    @Override
    public void saveDoctor(Doctor doctor) {
        doctorDao.saveDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorDao.getAllDoctor();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorDao.getDoctorById(doctorId);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        doctorDao.deleteDoctorById(doctorId);
    }

    @Override
    public void updateDoctorId(Doctor doctor) {
        doctorDao.updateDoctorId(doctor.getId(), doctor);
    }
}
