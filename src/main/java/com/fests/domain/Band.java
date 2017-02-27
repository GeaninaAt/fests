package com.fests.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@Entity
public class Band extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private Type type;

    @ManyToOne
    private Festival festival;

    public  Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type{
        DEATH_METAL,
        PROGRESSIVE_METAL;
    }
}
