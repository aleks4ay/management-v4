package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Description;
import ua.aleks4ay.kiyv_management.repo.DescriptionRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DescriptionService {

    @Autowired
    private DescriptionRepo repo;

    public Description findOne(String complexId) {
        String[] key = complexId.split("-");
        return repo.findByIdDocAndPosition(key[0], Integer.valueOf(key[1]));
    }



    public List<Description> getAll() {
        return repo.findAll();
    }

    public List<Description> findFirstFive(String idDoc) {
        return repo.findFirst7ByIdDoc(idDoc);
    }

//    public List<Description> getAllSorted(String sortMethod) {
//        return repo.findAll(Sort.by(Sort.Direction.ASC, sortMethod));
//    }
}
