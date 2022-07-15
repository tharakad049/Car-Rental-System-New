package lk.example.spring.repo;

import lk.example.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,  String>{

    @Query("select c from Customer c where c.cusId=?1")
    public Customer getCustomerById(String id);

    @Query(value = "select cusId from Customer order by cusId desc LIMIT 1", nativeQuery = true)
    String generateCustomerId();

    @Query(value = "select COUNT(*) from Customer", nativeQuery = true)
    int countSavedCustomers();
}
