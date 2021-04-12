package ua.aleks4ay.kiyv_management.model;

public class Invoice extends AbstractEntity<Invoice>{
    private int autoId;
    private String idDoc;
    private String idOrder;
    private double price;

    public Invoice(String idDoc, String idOrder, double price) {
        this.idDoc = idDoc;
        this.idOrder = idOrder;
        this.price = price;
    }

    @Override
    public Invoice getEntity() {
        return this;
    }

    @Override
    public String getId() {
        return idDoc;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Invoice that = (Invoice) obj;

        return idDoc.equals(that.idDoc)
                && idOrder.equals(that.idOrder)
                && Double.compare(price, that.getPrice()) == 0;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idDoc='" + idDoc + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", price=" + price +
                '}';
    }
}
