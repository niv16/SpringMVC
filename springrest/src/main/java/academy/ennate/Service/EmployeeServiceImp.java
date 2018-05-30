package academy.ennate.Service;

import academy.ennate.Entity.Employee;
import academy.ennate.Exception.BadRequestException;
import academy.ennate.Exception.EmployeeNotFoundException;
import academy.ennate.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> findAll() {
      return repo.findAll();
    }

    public Employee findOne(String id) {
        Employee emp = repo.findOne(id);
        if(emp == null)      {
            throw new EmployeeNotFoundException("Employee with id= "+id+" not found");
        }
        else {
            return emp;
        }
    }

    @Transactional
    public Employee create(Employee emp) {
//        Employee existing = repo.findByEmail(emp.getEmail());
//        if(existing != null)      {
//            throw new BadRequestException("Employee with id= "+emp.getEmail()+" already exists.");
//        }
        return repo.create(emp);
    }

    @Transactional
    public Employee update(String id, Employee emp) {
        Employee existing = repo.findOne(id);
        if(existing == null)      {
            throw new EmployeeNotFoundException("Employee with id= "+id+" not found");
        }
        else {
            return repo.update(emp);
        }
    }

    @Transactional
    public void delete(String id) {
        Employee existing = repo.findOne(id);
        if(existing == null)      {
            throw new EmployeeNotFoundException("Employee with id= "+id+" not found");
        }
        else {
            repo.delete(existing);
        }


    }
}
