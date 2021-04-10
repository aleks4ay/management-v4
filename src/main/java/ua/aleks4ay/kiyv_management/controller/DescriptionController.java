package ua.aleks4ay.kiyv_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aleks4ay.kiyv_management.model.Description;
import ua.aleks4ay.kiyv_management.services.DescriptionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DescriptionController {
    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/descr")
    public String getAllDescriptions(Map<String, Object> model) {
        List<Description> descriptions = descriptionService.getAll();//Sorted("idDoc");
        model.put("descriptions", descriptions);
        return "description_form";
    }

    @GetMapping("/descr_one")
    public String getOne(Map<String, Object> model) {
        Description description = descriptionService.findOne("  EYSJ-8");//Sorted("idDoc");
        List<Description> descriptions = new ArrayList<>();
        descriptions.add(description);
        model.put("descriptions", descriptions);
        return "description_form";
    }

    @GetMapping("/descr_five")
    public String getFirstFive(Map<String, Object> model) {
        List<Description> descriptions = descriptionService.findFirstFive("  EYSJ");
        model.put("descriptions", descriptions);
        return "description_form";
    }
}
