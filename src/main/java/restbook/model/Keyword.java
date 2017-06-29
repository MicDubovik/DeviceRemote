package restbook.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "keyword")
public class Keyword implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean off;


    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Keyword() {
    }

    public Keyword(String name, boolean off, Device device) {
        this.name = name;
        this.off = off;
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOff() {
        return off;
    }

    public void setOff(boolean off) {
        this.off = off;
    }
}

