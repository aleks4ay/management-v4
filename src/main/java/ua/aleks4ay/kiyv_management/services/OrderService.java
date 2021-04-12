package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.*;
import ua.aleks4ay.kiyv_management.repo.OrderRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return repo.findAll(sortedPage);
    }

    public void addJournal(List<Journal> journals, Page<Order> orders) {
        Map<String, Journal> journalMap = new HashMap<>();
        for (Journal j : journals) {
            journalMap.put(j.getId(), j);
        }
        for (Order o : orders) {
            o.setJournal(journalMap.get(o.getIdDoc()));
        }
    }

    public void addListDescriptions(List<Description> descriptions, Page<Order> orderPage) {
        Map<String, Order> orderMap = new HashMap<>();
        for (Order o : orderPage) {
            orderMap.put(o.getId(), o);
        }
        for (Description d : descriptions) {
            Order tempOrder = orderMap.get(d.getIdDoc());
            if (tempOrder != null) {
                tempOrder.addDescriptions(d);
            }
        }
    }

    public void addClient(List<Client> clients, Page<Order> orders) {
        Map<String, Client> clientMap = new HashMap<>();
        for (Client c : clients) {
            clientMap.put(c.getId(), c);
        }
        for (Order o : orders) {
            o.setClient(clientMap.get(o.getIdClient()));
        }
    }

    public void addManager(List<Worker> manajers, Page<Order> orders) {
        Map<String, Worker> workerMap = new HashMap<>();
        for (Worker m : manajers) {
            workerMap.put(m.getId(), m);
        }
        for (Order o : orders) {
            o.setManager(workerMap.get(o.getIdManager()));
        }
    }
}
