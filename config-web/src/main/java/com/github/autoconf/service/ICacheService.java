package com.github.autoconf.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cache服务
 * Created by harry on 2015-10-07 16:55.
 */
public interface ICacheService {
  AtomicInteger getRetryLimit(String username);

  void clearRetryCache(String username);
}
