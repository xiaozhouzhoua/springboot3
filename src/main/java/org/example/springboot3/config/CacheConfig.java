package org.example.springboot3.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig implements CachingConfigurer {

    /**
     * afterCommit：在事务提交后执行
     *
     * @return CacheManager
     */
    @Bean
    @Override
    public CacheManager cacheManager() {
        return new TransactionAwareCacheManagerProxy(new ConcurrentMapCacheManager());
    }
}
