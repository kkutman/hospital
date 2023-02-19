package peaksoft.dao;

import peaksoft.models.Department;

import java.util.List;

/**
 * name : kutman
 **/
public interface DepartmentDao {
    void saveDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long departmentId);
    void deleteDepartmentById(Long departmentId);
    void updateDepartmentId(Long departmentId,Department department);
}
