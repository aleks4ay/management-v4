package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
}
