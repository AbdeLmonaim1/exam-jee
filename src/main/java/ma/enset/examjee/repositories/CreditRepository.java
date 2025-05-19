package ma.enset.examjee.repositories;

import ma.enset.examjee.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
