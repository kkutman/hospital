package peaksoft.dao;

import peaksoft.models.Hospital;

import java.util.List;

/**
 * name : kutman
 **/
public interface HospitalDao {
    void saveHospital(Hospital hospital);
    List<Hospital>getAllHospital();
    Hospital getHospitalById(Long hospitalId);
    void deleteHospitalById(Long hospitalId);
    void updateHospitalId(Long hospitalId,Hospital hospital);

}
