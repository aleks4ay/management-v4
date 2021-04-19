package ua.aleks4ay.kiyv_management.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "descriptions")
public class Description{
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

    @Transient
    private String status;

    @Column(name = "type_name", columnDefinition = "varchar(30) default 'TYPE_NEW';") //columnDefinition = "varchar(30) default 'TYPE_NEW';"
    private String typeName;

    @Transient
    private Worker designer;

    @Transient
    private Tmc tmc;

    @Transient
    private Type type;

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


    public Description getEntity() {
        return this;
    }

    public String getId() {
        String suffix = String.valueOf(1000 + position);
        return idDoc + "-" + suffix.substring(1);
    }

    public String getDescr() {
        if (descrSecond == null | descrSecond.equals("")) {
            return tmc.getDescrAll();
        }
        return descrSecond;
    }

    public Worker getDesigner() {
        if (designer != null) {
            return designer;
        }
        return new Worker("     0", "-");
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
}
