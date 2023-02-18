package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Department;
import peaksoft.repository.DepartmentRepository;

import java.util.List;
@Repository
@Transactional
public class DepartmentRepoImpl  implements DepartmentRepository {
    private  EntityManager entityManager;
    @Override
    public Department save(Department department) {
         entityManager.persist(department);
        return department;
    }

    @Override
    public List<Department> getAll() {
        return entityManager.createQuery("select d from Department  d",Department.class).getResultList();
    }

    @Override
    public Department findById(Long id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Department.class,id));
    }

    @Override
    public void update(Long id, Department newDepartment) {
        Department department = entityManager.find(Department.class, id);
        department.setName(newDepartment.getName());

    }
}
