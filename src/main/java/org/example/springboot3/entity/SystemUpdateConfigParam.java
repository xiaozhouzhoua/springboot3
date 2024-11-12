package org.example.springboot3.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(title = "系统配置更新请求参数")
public class SystemUpdateConfigParam {
    /** 系统配置键 */
    @Schema(title = "系统配置键", type = "String")
    @NotBlank(message = "系统配置键不能为空！")
    private String configKey;

    /** 系统配置值 */
    @Schema(title = "系统配置值", type = "String")
    private String configValue;

    /** 更新人ID */
    @Schema(title = "更新人ID", type = "Long")
    private Long updater;
}
