package org.example.springboot3.config;

import com.ejlchina.okhttps.Config;
import com.ejlchina.okhttps.HTTP;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpsConfig implements Config {
    @Override
    public void with(HTTP.Builder builder) {
        // 在这里对 HTTP.Builder 做一些自定义的配置
        builder.config((OkHttpClient.Builder okBuilder) -> {
            // 连接超时时间（默认10秒）
            okBuilder.connectTimeout(10, TimeUnit.SECONDS);
            // 写入超时时间（默认10秒）
            okBuilder.writeTimeout(10, TimeUnit.SECONDS);
            // 读取超时时间（默认10秒）
            okBuilder.readTimeout(10, TimeUnit.SECONDS);
        }).build();
    }
}
