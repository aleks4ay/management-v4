package ua.aleks4ay.kiyv_management.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<Order>{
    @Id
    @GeneratedValue
    private long autoId;

    @Column(name = "iddoc")
    private String idDoc;
    @Column(name = "id_client")
    private String idClient;
    @Column(name = "id_manager")
    private String idManager;
    @Column(name = "duration")
    private int durationTime;
    @Column(name = "t_factory")
    private Timestamp dateToFactory;

    private double price;

    @Transient
    private List<Description> descriptions;

    @Transient
    private Client client;
    @Transient
    private Worker manager;
    @Transient
    private Journal journal;

    public Order() {
    }

    public Order(String idDoc, String idClient, String idManager, int durationTime, Timestamp date, double price) {
        this.idDoc = idDoc;
        this.idClient = idClient;
        this.idManager = idManager;
        this.durationTime = durationTime;
        this.dateToFactory = date;
        this.price = price;
    }

    public long getAutoId() {
        return autoId;
    }

    public void setAutoId(long autoId) {
        this.autoId = autoId;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public Timestamp getDateToFactory() {
        return dateToFactory;
    }

    public void setDateToFactory(Timestamp dateToFactory) {
        this.dateToFactory = dateToFactory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Worker getManager() {
        return manager;
    }

    public void setManager(Worker manager) {
        this.manager = manager;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescriptions(Description description) {
        if (descriptions == null) {
            descriptions = new ArrayList<>();
        }
        descriptions.add(description);
    }


    public Description getFirstDescription() {
        if (descriptions != null && !descriptions.isEmpty()) {
            return descriptions.get(0);
        }
        return null;
    }

    public int getSize() {
        return descriptions.size();
    }

    @Override
    public String toString() {
        return "Order{" +
                ", idDoc='" + idDoc + '\'' +
                ", idClient='" + idClient + '\'' +
                ", idManager='" + idManager + '\'' +
                ", durationTime=" + durationTime +
                ", dateToFactory=" + dateToFactory +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Order that = (Order) obj;

        return idDoc.equalsIgnoreCase(that.getIdDoc())
                && idClient.equalsIgnoreCase(that.getIdClient())
                && idManager.equalsIgnoreCase(that.getIdManager())
                && durationTime == that.getDurationTime()
                && price == that.getPrice()
                && dateToFactory == null
                    ? that.getDateToFactory() == null
                    : that.getDateToFactory() !=null && dateToFactory.getTime() == that.getDateToFactory().getTime();
    }

    @Override
    public String getId() {
        return idDoc;
    }

    @Override
    public Order getEntity() {
        return this;
    }

    public String getAllStringDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return dateToFactory.toLocalDateTime().format(formatter);
    }

    public String getShortStringDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateToFactory.toLocalDateTime().format(formatter);
    }
}
