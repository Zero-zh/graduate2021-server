package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Campus implements Serializable {
    private String id;

    private String title;

    private String time;

    private Integer type;

    private Integer clicks;

    private Integer status;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append(", clicks=").append(clicks);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}