package org.example.springboot3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName(value = "system_config")
@Schema(title = "系统配置实体")
public class SystemConfig extends BaseEntity{
    @TableId(type = IdType.AUTO)
    @Schema(title = "系统配置 id", type = "Long")
    private Long id;

    /** 系统配置名称 */
    @TableField(value = "name")
    @Schema(title = "系统配置名称", type = "String")
    private String name;

    /** 配置类型：0->基础配置；1->网站配置 */
    @TableField(value = "type")
    @Schema(title = "配置类型", type = "Integer")
    private Integer type;

    /** 系统配置键 */
    @TableField(value = "config_key")
    @Schema(title = "系统配置键", type = "String")
    private String configKey;

    /** 系统配置值 */
    @TableField(value = "config_value")
    @Schema(title = "系统配置值", type = "String")
    private String configValue;

    /** 系统配置描述 */
    @TableField(value = "description")
    @Schema(title = "系统配置描述", type = "String")
    private String description;
}
