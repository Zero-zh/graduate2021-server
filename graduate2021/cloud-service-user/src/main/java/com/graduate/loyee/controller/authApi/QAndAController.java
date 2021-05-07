package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.entity.AskAnswer;
import com.graduate.loyee.entity.Experience;
import com.graduate.loyee.service.QAndAService;
import com.graduate.loyee.utils.result.DataResult;
import com.graduate.loyee.vo.BaseVo.PageOutputVo;
import com.graduate.loyee.vo.QAndAVo.AskQuestionVo;
import com.graduate.loyee.vo.QAndAVo.QueryAskAnswerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/qAndAForum")
@Api(tags = "答疑论坛")
@RestController
@Slf4j
public class QAndAController {
    @Autowired
    private QAndAService qAndAService;

    @GetMapping("/getAskAndAnswerData")
    @ApiOperation(value = "你问我答查询")
    public DataResult<PageOutputVo<List<AskAnswer>>> getNationalExamData(QueryAskAnswerVo para){
        DataResult<PageOutputVo<List<AskAnswer>>> result = DataResult.success();
        try {
            PageOutputVo<List<AskAnswer>> loginReturn = qAndAService.getAskAndAnswerData(para);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @PostMapping("/addAskQuestion")
    @ApiOperation(value = "你问我答新增")
    public DataResult<List<AskAnswer>> askQuestion(AskQuestionVo para){
        Boolean flag = true;
        DataResult<List<AskAnswer>> result = DataResult.success();
        try {
            List<AskAnswer> loginReturn = qAndAService.askQuestion(para);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            flag = false;
//            return DataResult.fail(-1,e.getMessage());
        }
        if(!flag){
            result.setCode(0);
            result.setMsg("-1");
            return result;
        }
        return result;
    }

    @DeleteMapping("/deleteAskQuestion")
    @ApiOperation(value = "你问我答删除")
    public DataResult<List<AskAnswer>> deleteAskQuestion(String questionId){
        DataResult<List<AskAnswer>> result = DataResult.success();
        try {
            List<AskAnswer> loginReturn = qAndAService.deleteAskQuestion(questionId);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @PutMapping("/updateAskQuestion")
    @ApiOperation(value = "你问我答更新")
    public DataResult<List<AskAnswer>> updateAskQuestion(AskAnswer para){
        DataResult<List<AskAnswer>> result = DataResult.success();
        try {
            List<AskAnswer> loginReturn = qAndAService.updateAskQuestion(para);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }


    @GetMapping("/getWorkExperience")
    @ApiOperation(value = "经验之谈查询")
    public DataResult<List<Experience>> getWorkExperience(){
        DataResult<List<Experience>> result = DataResult.success();
        try {
            List<Experience> loginReturn = qAndAService.getWorkExperience();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

}
