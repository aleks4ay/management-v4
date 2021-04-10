package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Order;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    Order findByIdDoc(String idDoc);

    @Override
    List<Order> findAll(Sort sort);

    Page<Order> findAll(Pageable pageable);
}
