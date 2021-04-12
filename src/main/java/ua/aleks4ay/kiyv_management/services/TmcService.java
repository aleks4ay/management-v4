package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Tmc;
import ua.aleks4ay.kiyv_management.repo.TmcRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TmcService {

    @Autowired
    private TmcRepo repo;

    public List<Tmc> getAll() {
        return repo.findAll();
    }

    public Map<String, Tmc> getAllAsMap() {
        Map<String, Tmc> result = new HashMap<>();
        for (Tmc tmc : repo.findAll()) {
            result.put(tmc.getId(), tmc);
        }
        return result;
    }

}
