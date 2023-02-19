package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.HospitalDao;
import peaksoft.models.Hospital;
import peaksoft.services.HospitalServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class HospitalServicesImpl implements HospitalServices {
    private final HospitalDao hospitalDao;
    @Override
    public void saveHospital(Hospital hospital) {
        hospitalDao.saveHospital(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public Hospital getHospitalById(Long hospitalId) {
        return hospitalDao.getHospitalById(hospitalId);
    }

    @Override
    public void deleteHospitalById(Long hospitalId) {
        hospitalDao.deleteHospitalById(hospitalId);
    }

    @Override
    public void updateHospitalId(Hospital hospital,Long id) {
        hospitalDao.updateHospitalId(id,hospital);
    }
}
