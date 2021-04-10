package ua.aleks4ay.kiyv_management.model;

import javax.persistence.*;

@Entity
@Table(name = "descriptions")
public class Description extends AbstractEntity<Description>{
    @Id
    @GeneratedValue
    private long autoId;

    @Column(name = "iddoc")
    private String idDoc;

    private int position;

    @Column(name = "id_tmc")
    private String idTmc;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "descr_second")
    private String descrSecond;

    @Column(name = "size_a")
    private int sizeA;

    @Column(name = "size_b")
    private int sizeB;

    @Column(name = "size_c")
    private int sizeC;

    @Column(name = "id_embodiment")
    private String idEmbodiment;

    @Column(name = "price")
    private Double price;

    @Override
    public Description getEntity() {
        return this;
    }

    @Override
    public String getId() {
        String suffix = String.valueOf(1000 + position);
        return idDoc + "-" + suffix.substring(1);
    }

    public Description() {
    }

    public Description(String idDoc, int position, String idTmc, int quantity, String descrSecond,
                       int sizeA, int sizeB, int sizeC, String idEmbodiment, Double price) {
        this.idDoc = idDoc;
        this.position = position;
        this.idTmc = idTmc;
        this.quantity = quantity;
        this.descrSecond = descrSecond;
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
        this.idEmbodiment = idEmbodiment;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getIdTmc() {
        return idTmc;
    }

    public void setIdTmc(String idTmc) {
        this.idTmc = idTmc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescrSecond() {
        return descrSecond;
    }

    public void setDescrSecond(String descrSecond) {
        this.descrSecond = descrSecond;
    }

    public int getSizeA() {
        return sizeA;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }

    public int getSizeC() {
        return sizeC;
    }

    public void setSizeC(int sizeC) {
        this.sizeC = sizeC;
    }

    public String getIdEmbodiment() {
        return idEmbodiment;
    }

    public void setIdEmbodiment(String idEmbodiment) {
        this.idEmbodiment = idEmbodiment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Description getDescription() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Description that = (Description) obj;

        return idDoc.equals(that.getIdDoc())
                && position == that.getPosition()
                && idTmc.equals(that.getIdTmc())
                && quantity == that.getQuantity()
                && descrSecond.equals(that.getDescrSecond())
                && sizeA == that.getSizeA()
                && sizeB == that.getSizeB()
                && sizeC == that.getSizeC()
                && Double.compare(price, that.getPrice()) == 0
                && idEmbodiment.equals(that.getIdEmbodiment());
    }

    @Override
    public String toString() {
        return "Description{" +
                "idDoc='" + idDoc + '\'' +
                ", position=" + position +
                ", idTmc='" + idTmc + '\'' +
                ", quantity=" + quantity +
                ", descrSecond='" + descrSecond + '\'' +
                ", sizeA=" + sizeA +
                ", sizeB=" + sizeB +
                ", sizeC=" + sizeC +
                ", idEmbodiment='" + idEmbodiment + '\'' +
                ", price=" + price +
                '}';
    }
}
