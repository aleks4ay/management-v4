package ua.aleks4ay.kiyv_management.model;

public class Embodiment extends AbstractEntity<Embodiment>{

    private int autoId;
    private String id;
    private String description;

    public Embodiment() {
    }

    public Embodiment(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public Embodiment getEntity() {
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Embodiment{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Embodiment that = (Embodiment) obj;

        return id.equals(that.getId())
                && description.equals(that.getDescription());
    }

    public Embodiment getEmbodiment() {
        return this;
    }
}
