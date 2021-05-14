package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.entity.Campus;
import com.graduate.loyee.entity.Epidemic;
import com.graduate.loyee.service.BroadcastService;
import com.graduate.loyee.utils.result.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/broadcast")
@Api(tags = "广播报道")
@RestController
@Slf4j
public class BroadcastController {
    @Autowired
    private BroadcastService broadcastService;

    @GetMapping("/getinfoData")
    @ApiOperation(value = "通知公告信息查询")
    public DataResult<List<Campus>> getinfoData(){
        DataResult<List<Campus>> result = DataResult.success();
        try {
            List<Campus> loginReturn = broadcastService.getinfoData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getResearchData")
    @ApiOperation(value = "科研成果列表查询")
    public DataResult<List<Campus>> getResearchData(){
        DataResult<List<Campus>> result = DataResult.success();
        try {
            List<Campus> loginReturn = broadcastService.getResearchData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getHistoryData")
    @ApiOperation(value = "历史热点信息查询")
    public DataResult<List<Campus>> getHistoryData(){
        DataResult<List<Campus>> result = DataResult.success();
        try {
            List<Campus> loginReturn = broadcastService.getHistoryData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getEpidemicInfo")
    @ApiOperation(value = "疫情通知信息查询")
    public DataResult<List<Epidemic>> getEpidemicInfo(){
        DataResult<List<Epidemic>> result = DataResult.success();
        try {
            List<Epidemic> loginReturn = broadcastService.getEpidemicData(1);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/getEpidemicNews")
    @ApiOperation(value = "疫情通知信息查询")
    public DataResult<List<Epidemic>> getEpidemicNews(){
        DataResult<List<Epidemic>> result = DataResult.success();
        try {
            List<Epidemic> loginReturn = broadcastService.getEpidemicData(2);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/homePageEpidemic")
    @ApiOperation(value = "主页疫情通知查询")
    public DataResult<List<Epidemic>> homePageEpidemic(){
        DataResult<List<Epidemic>> result = DataResult.success();
        try {
            List<Epidemic> loginReturn = broadcastService.getEpidemicData(null);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }


}
