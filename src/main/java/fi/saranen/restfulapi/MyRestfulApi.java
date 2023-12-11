package fi.saranen.restfulapi;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MyRestfulApi {

    List<Customer> db;

    @PostConstruct
    public void init() {
        db = new ArrayList<Customer>();
        db.add(new Customer("jack"));
        db.add(new Customer("hannah"));
    }

    // http://localhost:8080/api/customers
    @GetMapping("api/customers")
    public List<Customer> getAll() {
        return db;
    }

    // http://localhost:8080/api/customers/1
    @GetMapping("api/customers/{userId}")
    public Customer getCustomerById(@PathVariable int userId) {
        return db.stream().filter(customer -> customer.getId() == userId).findFirst().get();
    }

    @PostMapping("api/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
         db.add(customer);
         return customer;
    }

    @DeleteMapping("api/customers/{userId}")
    public void deleteCustomerById(@PathVariable int userId) {
        db = db.stream().filter(customer -> customer.getId() != userId).collect(Collectors.toList());
    }
}
