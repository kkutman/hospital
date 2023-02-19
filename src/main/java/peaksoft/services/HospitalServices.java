package peaksoft.services;

import peaksoft.models.Hospital;

import java.util.List;

/**
 * name : kutman
 **/
public interface HospitalServices {
    void saveHospital(Hospital hospital);
    List<Hospital> getAllHospital();
    Hospital getHospitalById(Long hospitalId);
    void deleteHospitalById(Long hospitalId);
    void updateHospitalId(Hospital hospital,Long id);
}
