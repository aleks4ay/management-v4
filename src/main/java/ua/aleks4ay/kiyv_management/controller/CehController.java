package ua.aleks4ay.kiyv_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aleks4ay.kiyv_management.model.Order;
import ua.aleks4ay.kiyv_management.services.*;

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
    private String sortMethod = "idDoc";
    private int numPage = 1;


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

//    @GetMapping("/order/sort")
//    public String getAllOrdersSort(@RequestParam("method") String method, Map<String, Object> model) {
//        this.sortMethod = method;
//        return "redirect:/order";
//    }

    @GetMapping("/ceh/pars")
    public String getPage(Map<String, Object> model) {
        Page<Order> orders = orderService.getAllPage(numPage, rowsOfPage, sortMethod);
        orderService.addJournal(journalService.getAll(), orders);
        orderService.addListDescriptions(descriptionService.getAllWithTmc(), orders);
        orderService.addClient(clientService.getAll(), orders);
        orderService.addManager(managerService.getAll(), orders);
        model.put("orders", orders);
        model.put("rows", rowsOfPage);
        model.put("page", numPage);
        model.put("descriptions", orders.getContent().get(0).getDescriptions());
        return "parsing_form";
    }
}
