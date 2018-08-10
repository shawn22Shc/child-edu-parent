package com.xsx.ce.pojo;

import java.io.Serializable;

public class ReTimeScore implements Serializable {

    private static final long serialVersionUID = 990869376406287900L;

    private Long id;

    private Integer start;

    private Integer end;

    private Long score;

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

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}