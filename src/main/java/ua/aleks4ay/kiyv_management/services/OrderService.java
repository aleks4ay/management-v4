package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Order;
import ua.aleks4ay.kiyv_management.repo.OrderRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService{

    @Autowired
    private OrderRepo repo;

    public Order findOne(String idDoc) {
        return repo.findByIdDoc(idDoc);
    }

    public List<Order> getAllSorted(String sortMethod) {
        return repo.findAll(Sort.by(Sort.Direction.ASC, sortMethod));
    }

    public Page<Order> getAllPage(int numPage, int rowsOfPage, String sortMethod) {
        numPage--;
        Pageable sortedPage;
        if (sortMethod.equalsIgnoreCase("idDoc")) {
            sortedPage = PageRequest.of(numPage, rowsOfPage, Sort.by(sortMethod));
        } else {
            sortedPage = PageRequest.of(numPage, rowsOfPage, Sort.by(sortMethod).and(Sort.by("idDoc")));
        }
//        Pageable sortedByPriceDesc = PageRequest.of(numPage, rowsOfPage, Sort.by("price").descending());
//        Pageable sortedByPriceDescIdDocAsc = PageRequest.of(numPage, rowsOfPage, Sort.by("price").descending().and(Sort.by("idDoc")));
        return repo.findAll(sortedPage);
    }
}
