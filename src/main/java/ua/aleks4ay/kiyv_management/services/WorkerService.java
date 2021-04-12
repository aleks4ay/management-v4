
package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Worker;
import ua.aleks4ay.kiyv_management.repo.WorkerRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WorkerService {

    @Autowired
    private WorkerRepo repo;

    public List<Worker> getAll() {
        return repo.findAll();
    }

}
