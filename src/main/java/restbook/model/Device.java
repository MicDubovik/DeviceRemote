package restbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private boolean conditions= false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private Set<Keyword> devices = new HashSet<Keyword>();

    public Device() {
    }

    public Device(String name) {
        this.name = name;

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

    public Set<Keyword> getdevices() {
        return devices;
    }

    public void setdevices(Set<Keyword> devices) {
        this.devices = devices;
    }

    public boolean isconditions() {
        return conditions;
    }

    public void setconditions(boolean conditions) {
        this.conditions = conditions;
    }

    public Set<Keyword> getDevices() {
        return devices;
    }

    public void setDevices(Set<Keyword> devices) {
        this.devices = devices;
    }
}

