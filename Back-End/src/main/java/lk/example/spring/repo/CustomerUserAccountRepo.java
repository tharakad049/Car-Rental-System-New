package lk.example.spring.repo;

import lk.example.spring.entity.CustomerUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerUserAccountRepo extends JpaRepository<CustomerUserAccount, String> {
}
