package academy.ennate.controller;

import academy.ennate.Entity.Employee;
import academy.ennate.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping( value="employees")
public class EmployeeController
{
    @Autowired
    private EmployeeService empservice;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll()
    {
        return empservice.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Employee findOne(@PathVariable("id") String id)
    {
        return empservice.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee)
    {
        return  empservice.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Employee update(@PathVariable("id") String id, @RequestBody Employee employee)
    {
        return employee;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable("id") String id)
    {}

}
