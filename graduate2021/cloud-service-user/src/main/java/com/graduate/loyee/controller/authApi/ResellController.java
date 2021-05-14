package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.entity.Transaction;
import com.graduate.loyee.service.ResellService;
import com.graduate.loyee.utils.result.DataResult;
import com.graduate.loyee.vo.ResellVo.SelectTransByConditionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/resell")
@Api(tags = "二手买卖")
@RestController
@Slf4j
public class ResellController {
    @Autowired
    private ResellService resellService;

    @GetMapping("/getResellData")
    @ApiOperation(value = "当面交易查询")
    public DataResult<List<Transaction>> getResellData(){
        DataResult<List<Transaction>> result = DataResult.success();
        try {
            List<Transaction> loginReturn = resellService.getResellData();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @PostMapping("/selectByCondition")
    @ApiOperation(value = "根据条件查询商品")
    public DataResult<List<Transaction>> selectByCondition(SelectTransByConditionVo para){
        DataResult<List<Transaction>> result = DataResult.success();
        try {
            List<Transaction> loginReturn = resellService.selectByCondition(para);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

}
