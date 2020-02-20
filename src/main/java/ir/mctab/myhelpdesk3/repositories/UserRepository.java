package ir.mctab.myhelpdesk3.repositories;

import ir.mctab.myhelpdesk3.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
