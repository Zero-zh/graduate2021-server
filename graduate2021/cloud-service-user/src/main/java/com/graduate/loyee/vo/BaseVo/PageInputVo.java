package com.graduate.loyee.vo.BaseVo;

import lombok.Data;

@Data
public class PageInputVo {

    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 每页多少条数据
     */
    private Integer showRowsPerPage;

}
