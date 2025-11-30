package dev.ngdangkietswe.try_spring_ai.repo;

import dev.ngdangkietswe.try_spring_ai.entity.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@Repository
public interface SoftwareEngineerRepo extends JpaRepository<SoftwareEngineer, Long> {
}
