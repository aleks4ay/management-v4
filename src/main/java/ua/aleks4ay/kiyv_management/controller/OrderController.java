package ua.aleks4ay.kiyv_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aleks4ay.kiyv_management.model.Journal;
import ua.aleks4ay.kiyv_management.model.Order;
import ua.aleks4ay.kiyv_management.repo.ClientRepo;
import ua.aleks4ay.kiyv_management.services.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

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


    @GetMapping("/")
    public String start() {
        return "redirect:/order";
    }

    @GetMapping("/order")
    public String getAllOrders(Map<String, Object> model) {
        Page<Order> orders = orderService.getAllPage(numPage, rowsOfPage, sortMethod);
        orderService.addJournal(journalService.getAll(), orders);
        orderService.addListDescriptions(descriptionService.getAllWithTmc(), orders);
        orderService.addClient(clientService.getAll(), orders);
        orderService.addManager(managerService.getAll(), orders);
        model.put("orders", orders);
        model.put("rows", rowsOfPage);
        model.put("page", numPage);
        return "order_form";
    }

    @GetMapping("/order/sort")
    public String getAllOrdersSort(@RequestParam("method") String method, Map<String, Object> model) {
        this.sortMethod = method;
        return "redirect:/order";
    }

    @GetMapping("/order/page")
    public String getPage(@RequestParam("p") String page, Map<String, Object> model) {
        int numPage = Integer.valueOf(page);
        if (numPage < 1) {
            numPage = 1;
        }
        this.numPage = numPage;
        return "redirect:/order";
    }
}
