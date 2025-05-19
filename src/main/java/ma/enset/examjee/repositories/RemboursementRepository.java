package ma.enset.examjee.repositories;

import ma.enset.examjee.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}
