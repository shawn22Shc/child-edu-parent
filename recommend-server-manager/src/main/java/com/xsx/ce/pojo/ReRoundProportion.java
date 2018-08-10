package com.xsx.ce.pojo;

import java.io.Serializable;

public class ReRoundProportion implements Serializable{

    private static final long serialVersionUID = -298959818497745232L;

    private Long id;

    private Integer start;

    private Integer end;

    private Integer artificialProportion;

    private Integer systemProportion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getArtificialProportion() {
        return artificialProportion;
    }

    public void setArtificialProportion(Integer artificialProportion) {
        this.artificialProportion = artificialProportion;
    }

    public Integer getSystemProportion() {
        return systemProportion;
    }

    public void setSystemProportion(Integer systemProportion) {
        this.systemProportion = systemProportion;
    }
}