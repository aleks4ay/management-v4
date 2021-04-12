package ua.aleks4ay.kiyv_management.model;

import java.sql.Timestamp;

public class TmcBalance extends AbstractEntity<TmcBalance>{

    private String idTmc;
    private int quantityOnStore;
    private Timestamp period;

    public TmcBalance() {
    }

    public TmcBalance(String idTmc, int quantityOnStore, Timestamp period) {
        this.idTmc = idTmc;
        this.quantityOnStore = quantityOnStore;
        this.period = period;
    }

    @Override
    public String getId() {
        return idTmc;
    }

    public String getIdTmc() {
        return idTmc;
    }

    public void setIdTmc(String idTmc) {
        this.idTmc = idTmc;
    }

    public int getQuantityOnStore() {
        return quantityOnStore;
    }

    public void setQuantityOnStore(int quantityOnStore) {
        this.quantityOnStore = quantityOnStore;
    }

    public Timestamp getPeriod() {
        return period;
    }

    public void setPeriod(Timestamp period) {
        this.period = period;
    }

    public TmcBalance getTmc() {
        return this;
    }

    @Override
    public String toString() {
        return "TmcBalance{" +
                "idTmc='" + idTmc + '\'' +
                ", quantityOnStore=" + quantityOnStore +
                ", period=" + period +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TmcBalance tmc = (TmcBalance) obj;

        return idTmc.equals(tmc.getIdTmc())
                && quantityOnStore == tmc.getQuantityOnStore()
                && period.getTime() == tmc.getPeriod().getTime();
    }

    @Override
    public TmcBalance getEntity() {
        return this;
    }
}
