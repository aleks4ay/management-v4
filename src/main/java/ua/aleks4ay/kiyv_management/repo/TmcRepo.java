package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Tmc;

@Repository
public interface TmcRepo extends JpaRepository<Tmc, Long> {
}
