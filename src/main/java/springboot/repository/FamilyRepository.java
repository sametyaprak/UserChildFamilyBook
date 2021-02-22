package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long> {
}
