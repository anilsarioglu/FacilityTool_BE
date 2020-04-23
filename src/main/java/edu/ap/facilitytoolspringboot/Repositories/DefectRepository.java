package edu.ap.facilitytoolspringboot.Repositories;

import edu.ap.facilitytoolspringboot.Models.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
