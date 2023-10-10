package kz.shady.assignment.repository;

import kz.shady.assignment.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Long> {
    Code findTopByOrderByIdDesc();
}
