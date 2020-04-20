package Animal.Hospital;

public class Treated extends AbstractEvent {

    private Long id;

    public Treated(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
