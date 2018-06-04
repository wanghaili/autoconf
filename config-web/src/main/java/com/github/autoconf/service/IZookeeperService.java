package com.github.autoconf.service;

import com.github.autoconf.entity.Config;

/**
 * 异步发布配置到zookeeper服务器
 *
 * Created by harry on 15/2/9.
 */
public interface IZookeeperService {

  void cpZookeeper(Config config);

  void rmZookeeper(Config config);

}
