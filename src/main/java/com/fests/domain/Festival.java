package com.fests.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@Entity
public class Festival extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private String name;
    private String location;

    @OneToMany
    private List<Band> bands;

    public List<Band> getBands() {
        return bands;
    }
    public void setBands(List<Band> bands) {
        this.bands = bands;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
