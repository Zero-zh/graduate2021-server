package com.graduate.loyee.vo.QAndAVo;

import com.graduate.loyee.vo.BaseVo.PageInputVo;
import lombok.Data;

@Data
public class QueryAskAnswerVo extends PageInputVo {
    private String type;
    private String content;
}
