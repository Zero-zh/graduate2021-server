package com.graduate.loyee.vo.BaseVo;

import lombok.Data;

@Data
public class PageOutputVo<T> {
    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 总条数
     */
    private Integer rowsCount;

    private T t;
}
