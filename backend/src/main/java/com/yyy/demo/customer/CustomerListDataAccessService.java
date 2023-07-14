package com.yyy.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.yyy.demo.customer.Gender.FEMALE;
import static com.yyy.demo.customer.Gender.MALE;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                "Alex",
                "alex@gmail.com",
                21,
                MALE
        );
        customers.add(alex);

        Customer Jamila = new Customer(
                "Jamila",
                "jamila@gmail.com",
                19,
                FEMALE
        );
        customers.add(Jamila);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Long customerId) {
        return customers.stream()
                .anyMatch(c -> c.getId().equals(customerId));
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .ifPresent(c -> customers.remove(c));
    }

    @Override
    public void updateCustomer(Customer customer) {
        customers.add(customer);
    }
}
