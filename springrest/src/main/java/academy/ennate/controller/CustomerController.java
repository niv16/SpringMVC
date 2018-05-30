package academy.ennate.controller;

import academy.ennate.Entity.Cust;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="ap/cust")
public class CustomerController {


    @RequestMapping(method = RequestMethod.GET)
    public List<Cust> findAll()
    {
        List<Cust> cust= new ArrayList<>();
        cust.add(new Cust( "niv", 100));
        cust.add(new Cust("niv", 1001));
        cust.add(new Cust("nivedita",2000));

        return cust;
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Cust findOne(@PathVariable("id") String id)
    {
        return new Cust("new niv",1000);
    }





}
