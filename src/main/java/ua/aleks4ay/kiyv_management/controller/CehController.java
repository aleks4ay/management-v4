package ua.aleks4ay.kiyv_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aleks4ay.kiyv_management.model.Description;
import ua.aleks4ay.kiyv_management.model.Order;
import ua.aleks4ay.kiyv_management.services.*;

import java.util.List;
import java.util.Map;

@Controller
public class CehController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private JournalService journalService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkerService managerService;

    private int rowsOfPage = 15;
    private int rowsOfPageParsing = 8;
    private String sortMethod = "idDoc";
    private int numPage = 1;
    private int numParsPage = 1;


    @GetMapping("/ceh")
    public String getAllOrders(Map<String, Object> model) {
        Page<Order> orders = orderService.getAllPage(numPage, rowsOfPage, sortMethod);
        orderService.addJournal(journalService.getAll(), orders);
        orderService.addListDescriptions(descriptionService.getAllWithTmc(), orders);
        orderService.addClient(clientService.getAll(), orders);
        orderService.addManager(managerService.getAll(), orders);
        model.put("orders", orders);
        model.put("rows", rowsOfPage);
        model.put("page", numPage);
        return "ceh_form";
    }

    @GetMapping("/ceh/pars")
    public String getParsPage(Map<String, Object> model) {
        Page<Order> orders = orderService.getAllPage(numParsPage, rowsOfPageParsing, sortMethod);
        orderService.addJournal(journalService.getAll(), orders);
        List<Description> allDescriptionList = descriptionService.getAllWithTmc();
        List<Description> currentDescriptions = orderService.addListDescriptions(allDescriptionList, orders);
        orderService.addClient(clientService.getAll(), orders);
        orderService.addManager(managerService.getAll(), orders);
        Order supperOrder = new Order();
        supperOrder.setDescriptions(currentDescriptions);
        model.put("orders", orders);
        model.put("rows", rowsOfPage);
        model.put("page", numParsPage);
        model.put("supperOrder", supperOrder);
        return "parsing_form";
    }

    @GetMapping("/ceh/page")
    public String setPage(@RequestParam("p") String page, Map<String, Object> model) {
        int numPage = Integer.valueOf(page);
        if (numPage < 1) {
            numPage = 1;
        }
        this.numPage = numPage;
        return "redirect:/ceh";
    }

    @GetMapping("/ceh/pars/page")
    public String setParsePage(@RequestParam("p") String page, Map<String, Object> model) {
        int numParsPage = Integer.valueOf(page);
        if (numParsPage < 1) {
            numParsPage = 1;
        }
        this.numParsPage = numParsPage;
        return "redirect:/ceh/pars";
    }

    @PostMapping("/ceh/pars/apply")
    public String applyParsing(@ModelAttribute(name = "supperOrder") Order supperOrder) {
        descriptionService.save(supperOrder.getDescriptions());
        return "redirect:/ceh/pars";
    }
}
