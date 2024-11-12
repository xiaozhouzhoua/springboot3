package org.example.springboot3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.springboot3.constant.CacheConstants;
import org.example.springboot3.entity.SystemConfig;
import org.example.springboot3.mapper.SystemConfigMapper;
import org.example.springboot3.service.SystemConfigService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {
    @Override
    @Cacheable(value = CacheConstants.SYSTEM_CONFIG, unless = "#result == null")
    public List<SystemConfig> queryAllConfig() {
        return this.baseMapper.queryAllConfig();
    }

    @Override
    public void updateConfig(String configKey, String configValue, Long userId) {
        Assert.isTrue(this.baseMapper.updateConfig(configKey, configValue, userId) > 0, "更新失败！");
    }
}
