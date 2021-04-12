package ua.aleks4ay.kiyv_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aleks4ay.kiyv_management.model.Journal;
import ua.aleks4ay.kiyv_management.repo.JournalRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class JournalService {

    @Autowired
    private JournalRepo repo;

//    public Journal findOne(String idDoc) {
//        return repo.findByIdDoc(idDoc);
//    }

    public List<Journal> getAll() {
        return repo.findAll();
    }
}
