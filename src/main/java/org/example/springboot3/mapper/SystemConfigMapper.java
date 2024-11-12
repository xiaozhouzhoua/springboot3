package org.example.springboot3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.springboot3.entity.SystemConfig;
import java.util.List;

public interface SystemConfigMapper extends BaseMapper<SystemConfig> {
    /**
     * 查询系统配置
     * @return 系统配置
     */
    List<SystemConfig> queryAllConfig();

    /**
     * 更新配置
     * @param configKey 配置键
     * @param configValue 配置值
     * @param updater 更新人
     */
    int updateConfig(@Param("configKey") String configKey,
                     @Param("configValue") String configValue,
                     @Param("updater") Long updater);
}
