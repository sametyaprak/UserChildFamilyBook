package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.entity.Child;

public interface ChildRepository extends JpaRepository<Child,Long> {
}
