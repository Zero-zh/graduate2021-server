package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.entity.Certificate;
import com.graduate.loyee.entity.EndExam;
import com.graduate.loyee.entity.NationalExam;
import com.graduate.loyee.service.ExaminationService;
import com.graduate.loyee.utils.result.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/examination")
@Api(tags = "考试考证")
@RestController
@Slf4j
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;

    @GetMapping("/getEndExamData")
    @ApiOperation(value = "期末攻略查询")
    public DataResult<List<EndExam>> getEndExamData(){
        DataResult<List<EndExam>> result = DataResult.success();
        try {
            List<EndExam> loginReturn = examinationService.getEndExamData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getCertificateData")
    @ApiOperation(value = "国家证书查询")
    public DataResult<List<Certificate>> getCertificateData(){
        DataResult<List<Certificate>> result = DataResult.success();
        try {
            List<Certificate> loginReturn = examinationService.getCertificateData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getNationalExamData")
    @ApiOperation(value = "国考备战查询")
    public DataResult<List<NationalExam>> getNationalExamData(){
        DataResult<List<NationalExam>> result = DataResult.success();
        try {
            List<NationalExam> loginReturn = examinationService.getNationalExamData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

}
