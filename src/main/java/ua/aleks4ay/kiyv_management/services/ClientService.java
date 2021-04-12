package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Client;
import ua.aleks4ay.kiyv_management.repo.ClientRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClientService {

    @Autowired
    private ClientRepo repo;

    public List<Client> getAll() {
        return repo.findAll();
    }

}
