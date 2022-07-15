package lk.example.spring.repo;

import lk.example.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminServiceRepo extends JpaRepository<Admin, String> {
}
