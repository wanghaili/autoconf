package com.github.autoconf.service;

import com.github.autoconf.entity.Config;

import java.util.List;

/**
 *
 * Created by harry on 2015/1/10.
 */
public interface IConfigService {

  void save(Config config);

  Config findById(Long id);

  List<Config> findAll();

  void clearCache();

  void delete(Config config);

  void updatePath(String path, Long id);
}

