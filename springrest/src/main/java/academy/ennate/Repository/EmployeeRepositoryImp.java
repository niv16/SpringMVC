package academy.ennate.Repository;

import academy.ennate.Entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository

public class EmployeeRepositoryImp implements EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query= entityManager.createNamedQuery("Employee.findAll", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee findOne(String id) {
       return entityManager.find(Employee.class,id);
    }

    public Employee findByEmail(String email){
        TypedQuery<Employee> query= entityManager.createNamedQuery("Employee.findByEmail", Employee.class);
        query.setParameter("paramEmail",email);
       List<Employee> empList = query.getResultList();
        if(empList!=null && empList.size()==1)
            return empList.get(0);
        else
        {
            return null;
        }
    }
    public Employee create(Employee emp){
        entityManager.persist(emp);
        return emp;
    }

    public  Employee update(Employee emp){
        return entityManager.merge(emp);
    }

    public  void delete(Employee emp){
        entityManager.remove(emp);
    }



}
