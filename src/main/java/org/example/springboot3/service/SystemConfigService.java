package org.example.springboot3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springboot3.entity.SystemConfig;

import java.util.List;

public interface SystemConfigService extends IService<SystemConfig> {
    /**
     * 查询系统配置
     * @return 系统配置
     */
    List<SystemConfig> queryAllConfig();

    /**
     * 更新配置
     * @param configKey 配置键
     * @param configValue 配置值
     * @param userId 更新人ID
     */
    void updateConfig(String configKey, String configValue, Long userId);
}
