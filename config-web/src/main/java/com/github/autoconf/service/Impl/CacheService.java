package com.github.autoconf.service.Impl;

import com.github.autoconf.service.ICacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cache服务
 * Created by harry on 2015-10-07 16:55.
 */
@Service("cacheService")
public class CacheService implements ICacheService{
  @Cacheable(value = "RetryLimitCache")
  public AtomicInteger getRetryLimit(String username) {
    return new AtomicInteger(0);
  }

  @CacheEvict(value = "RetryLimitCache")
  public void clearRetryCache(String username) {
  }
}
