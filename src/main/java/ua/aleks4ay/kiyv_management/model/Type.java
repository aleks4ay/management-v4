package ua.aleks4ay.kiyv_management.model;

public enum Type {
    TYPE_NEW("новый"),
    TYPE_KB("КБ"),
    TYPE_CEH("ЦЕХ"),
    TYPE_TEHN("Технологич."),
    TYPE_ABC("АВС"),
    TYPE_OTHER("Прочее");

    private String name;

    Type(String name) {
        this.name = name;
    }

     public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Type type = TYPE_ABC;
        System.out.println(type.toString());
        System.out.println(type.getName());
        type = Type.values()[1];
        System.out.println(type.toString());
        System.out.println(type.getName());
        type = Type.valueOf("TYPE_NEW");
        System.out.println(type.toString());
        System.out.println(type.getName());
    }
}