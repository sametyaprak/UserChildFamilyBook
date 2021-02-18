package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Child;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {

}
