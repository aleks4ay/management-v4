package ua.aleks4ay.kiyv_management.model;

public class Manufacture extends AbstractEntity<Manufacture> {
    private String idDoc;
    private String idOrder;
    private int position;
    private int quantity;
    private String idTmc;
    private String descrSecond;
    private int sizeA;
    private int sizeB;
    private int sizeC;
    private String embodiment;

    public Manufacture(String idDoc, String idOrder, int position, int quantity, String idTmc,
                       String descrSecond, int sizeA, int sizeB, int sizeC, String embodiment) {
        this.idDoc = idDoc;
        this.idOrder = idOrder;
        this.position = position;
        this.quantity = quantity;
        this.idTmc = idTmc;
        this.descrSecond = descrSecond;
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
        this.embodiment = embodiment;
    }

    @Override
    public Manufacture getEntity() {
        return this;
    }

    @Override
    public String getId() {
        return idDoc + "-" + position;
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

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIdTmc() {
        return idTmc;
    }

    public void setIdTmc(String idTmc) {
        this.idTmc = idTmc;
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

    public String getEmbodiment() {
        return embodiment;
    }

    public void setEmbodiment(String embodiment) {
        this.embodiment = embodiment;
    }

    public Manufacture getManufacture() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Manufacture that = (Manufacture) obj;

        return idDoc.equals(that.idDoc)
                && (position == that.position)
                && idOrder.equals(that.idOrder)
                && quantity == that.quantity
                && idTmc.equals(that.idTmc)
                && descrSecond.equals(that.descrSecond)
                && sizeA == that.sizeA
                && sizeB == that.sizeB
                && sizeC == that.sizeC
                && embodiment.equals(that.embodiment);
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "idDoc='" + idDoc + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", position=" + position +
                ", quantity=" + quantity +
                ", idTmc='" + idTmc + '\'' +
                ", descrSecond='" + descrSecond + '\'' +
                ", sizeA=" + sizeA +
                ", sizeB=" + sizeB +
                ", sizeC=" + sizeC +
                ", embodiment='" + embodiment + '\'' +
                '}';
    }
}
