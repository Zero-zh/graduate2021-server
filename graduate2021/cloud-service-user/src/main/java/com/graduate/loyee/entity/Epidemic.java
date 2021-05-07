package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Epidemic implements Serializable {
    private String id;

    private Integer type;

    private String info;

    private String time;

    private String source;

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
        sb.append(", type=").append(type);
        sb.append(", info=").append(info);
        sb.append(", time=").append(time);
        sb.append(", source=").append(source);
        sb.append(", clicks=").append(clicks);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}