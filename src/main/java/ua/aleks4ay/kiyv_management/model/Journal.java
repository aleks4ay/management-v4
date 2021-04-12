package ua.aleks4ay.kiyv_management.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "journal")
public class Journal extends AbstractEntity<Journal>{

    @Id
    @GeneratedValue
    private long autoId;
    @Column(name = "iddoc")
    private String idDoc;
    @Column(name = "docno")
    private String docNumber;
    @Column(name = "datecreate")
    private Timestamp dateCreate;

    public Journal() {
    }

    public Journal(String idDoc, String docNumber, Timestamp dateCreate) {
        this.idDoc = idDoc;
        this.docNumber = docNumber;
        this.dateCreate = dateCreate;
    }

    @Override
    public Journal getEntity() {
        return this;
    }

    @Override
    public String getId() {
        return idDoc;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public long getAutoId() {
        return autoId;
    }

    public void setAutoId(long autoId) {
        this.autoId = autoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        return getIdDoc().equals(journal.getIdDoc())
                && getDocNumber().equals(journal.getDocNumber())
                && this.getDateCreate().getTime() == journal.getDateCreate().getTime();
    }

    @Override
    public int hashCode() {
        int result = getIdDoc().hashCode();
        result = 31 * result + getDocNumber().hashCode();
        result = 31 * result + getDateCreate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "idDoc='" + idDoc + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", dateCreate=" + dateCreate +
                '}';
    }

    public String getShortStringDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateCreate.toLocalDateTime().format(formatter);
    }
}
