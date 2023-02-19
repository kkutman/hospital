package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.dao.DepartmentDao;
import peaksoft.models.Department;

import java.util.List;

/**
 * name : kutman
 **/
@Repository
@Transactional
@RequiredArgsConstructor
public class DepartmentDaoImpl implements DepartmentDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveDepartment(Department department) {
        entityManager.persist(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return entityManager.createQuery("select d from Department  d", Department.class).getResultList();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return entityManager.find(Department.class,departmentId);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        entityManager.remove(entityManager.find(Department.class,departmentId));
    }

    @Override
    public void updateDepartmentId(Long departmentId, Department department) {
        Department department1 = entityManager.find(Department.class, departmentId);
        department1.setName(department.getName());

    }
}
