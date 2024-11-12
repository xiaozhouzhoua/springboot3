package org.example.springboot3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springboot3.common.CommonResult;
import org.example.springboot3.constant.MessageConstants;
import org.example.springboot3.entity.SystemConfig;
import org.example.springboot3.entity.SystemUpdateConfigParam;
import org.example.springboot3.service.SystemConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name = "系统配置接口")
@RequestMapping("/systemConfig")
@RestController
@RequiredArgsConstructor
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    @GetMapping("/getAllConfig")
    @Operation(summary = "获取系统配置")
    public CommonResult<List<SystemConfig>> getAllConfig(){
        return CommonResult.success(systemConfigService.queryAllConfig());
    }

    @PutMapping("/updateConfig")
    @Operation(summary = "更新配置接口")
    public CommonResult<Void> updateConfig(@RequestBody @Valid SystemUpdateConfigParam param) {
        systemConfigService.updateConfig(param.getConfigKey(), param.getConfigValue(), param.getUpdater());
        return CommonResult.success(MessageConstants.SUCCESS);
    }
}
