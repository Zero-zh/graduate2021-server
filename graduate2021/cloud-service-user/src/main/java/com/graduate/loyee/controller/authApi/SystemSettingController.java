package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.service.SystemSettingService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/system")
@Api(tags = "系统设置")
@RestController
@Slf4j
public class SystemSettingController {
    @Autowired
    private SystemSettingService systemSettingService;

}
