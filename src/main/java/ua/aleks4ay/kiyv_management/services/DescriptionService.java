package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Description;
import ua.aleks4ay.kiyv_management.model.Tmc;
import ua.aleks4ay.kiyv_management.model.Type;
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
        return descriptionRepo.findAll(Sort.by("idDoc").and(Sort.by("position")));
    }

    public List<Description> getAllWithTmc() {
        List<Description> descriptions = descriptionRepo.findAll(
                Sort.by(Sort.Direction.ASC, "idDoc").
                and(
                Sort.by(Sort.Direction.ASC, "position")));
        Map<String, Tmc> tmcMap = tmcService.getAllAsMap();
        for (Description d : descriptions) {
            d.setTmc(tmcMap.get(d.getIdTmc()));
            d.setType(Type.valueOf(d.getTypeName()));
        }
        return descriptions;
    }



    public List<Description> findFirstFive(String idDoc) {
        return descriptionRepo.findFirst7ByIdDoc(idDoc);
    }

//    public List<Description> getAllSorted(String sortMethod) {
//        return repo.findAll(Sort.by(Sort.Direction.ASC, sortMethod));
//    }

    @Transactional
    public void save(List<Description> descriptions) {
        descriptionRepo.saveAll(descriptions);
    }
}
