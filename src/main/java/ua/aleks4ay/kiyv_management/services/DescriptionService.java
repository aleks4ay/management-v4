package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Description;
import ua.aleks4ay.kiyv_management.model.Tmc;
import ua.aleks4ay.kiyv_management.repo.DescriptionRepo;
import ua.aleks4ay.kiyv_management.repo.TmcRepo;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class DescriptionService {

    @Autowired
    private DescriptionRepo descriptionRepo;
    @Autowired
    private TmcService tmcService;

    public Description findOne(String complexId) {
        String[] key = complexId.split("-");
        return descriptionRepo.findByIdDocAndPosition(key[0], Integer.valueOf(key[1]));
    }



    public List<Description> getAll() {
        return descriptionRepo.findAll();
    }

    public List<Description> getAllWithTmc() {
        List<Description> descriptions = descriptionRepo.findAll();
        Map<String, Tmc> tmcMap = tmcService.getAllAsMap();
        for (Description d : descriptions) {
            d.setTmc(tmcMap.get(d.getIdTmc()));
        }
        return descriptions;
    }



    public List<Description> findFirstFive(String idDoc) {
        return descriptionRepo.findFirst7ByIdDoc(idDoc);
    }

//    public List<Description> getAllSorted(String sortMethod) {
//        return repo.findAll(Sort.by(Sort.Direction.ASC, sortMethod));
//    }
}
