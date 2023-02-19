package peaksoft.services;

import peaksoft.models.Department;

import java.util.List;

/**
 * name : kutman
 **/
public interface DepartmentServices {
    void saveDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long departmentId);
    void deleteDepartmentById(Long departmentId);
    void updateDepartmentId(Long id,Department department);
}
