package com.yyy.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomer();
    }

    @GetMapping("{CustomerId}")
    public Customer getCustomer(@PathVariable("CustomerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }
    @DeleteMapping("{CustomerId}")
    public void deleteCustomer(
            @PathVariable("CustomerId") Long customerId){
        customerService.deleteCustomerById(customerId);
    }
    @PutMapping("{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            // This annotation binds the customerId path variable from the request URI to the Long parameter customerId in the method signature. It allows you to access the customer identifier passed in the URI.
            @RequestBody CustomerUpdateRequest updateRequest){
        // This annotation binds the request body to the CustomerUpdateRequest object. The updateRequest parameter represents the updated data sent in the request payload.
        customerService.updateCustomer(customerId, updateRequest);
    }
}
