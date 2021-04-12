package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Worker;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {
}
