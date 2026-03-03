package petkingdom.model;

public class Service {
    private String id;
    private String name;

    public Service(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("|-5%s|-20%s|\n",this.id,this.name);
    }
}
