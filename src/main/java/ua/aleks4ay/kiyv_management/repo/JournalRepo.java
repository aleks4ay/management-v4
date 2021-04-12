package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Journal;

import java.util.List;

@Repository
public interface JournalRepo extends JpaRepository<Journal, Long> {

    Journal findByIdDoc(String idDoc);

//    @Override
//    List<Order> findAll(Sort sort);

//    List<Journal> findAll();
}
