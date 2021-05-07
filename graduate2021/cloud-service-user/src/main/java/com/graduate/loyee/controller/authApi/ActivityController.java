package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.entity.Competition;
import com.graduate.loyee.entity.ComprehensiveTest;
import com.graduate.loyee.service.ActivityService;
import com.graduate.loyee.utils.result.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/activity")
@Api(tags = "活动竞赛")
@RestController
@Slf4j
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/getComprehensiveUpData")
    @ApiOperation(value = "综测活动首部信息查询")
    public DataResult<List<ComprehensiveTest>> getComprehensiveUpData(){
        DataResult<List<ComprehensiveTest>> result = DataResult.success();
        try {
            List<ComprehensiveTest> loginReturn = activityService.getComprehensiveData(0,9);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getComprehensiveDownData")
    @ApiOperation(value = "综测活动尾部信息查询")
    public DataResult<List<ComprehensiveTest>> getComprehensiveDownData(){
        DataResult<List<ComprehensiveTest>> result = DataResult.success();
        try {
            List<ComprehensiveTest> loginReturn = activityService.getComprehensiveData(9,9);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }


    @GetMapping("/getCompetitionData")
    @ApiOperation(value = "竞赛专区信息查询")
    public DataResult<List<Competition>> getCompetitionData(){
        DataResult<List<Competition>> result = DataResult.success();
        try {
            List<Competition> loginReturn = activityService.getCompetitionData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }



}
