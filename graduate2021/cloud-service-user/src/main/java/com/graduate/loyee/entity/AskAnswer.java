package com.graduate.loyee.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AskAnswer implements Serializable {
    private String id;

    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private String time;

    private String title;

    private String type;

    private String author;

    private Integer replyNums;

    private String remarks;

    private Integer status;

    private String desc;

    private static final long serialVersionUID = 1L;

}