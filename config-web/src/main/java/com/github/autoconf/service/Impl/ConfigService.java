package com.github.autoconf.service.Impl;

import com.github.autoconf.entity.Config;
import com.github.autoconf.mapper.ConfigMapper;
import com.github.autoconf.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Dao访问层
 *
 * Created by harry on 2015/1/10.
 */
@Service("configService")
public class ConfigService implements IConfigService{
  private static final String NAME = "ConfigCache";
  @Autowired
  private ConfigMapper mapper;

  @Override
  @CacheEvict(value = NAME, allEntries = true)
  public void save(Config config) {
    if (config.isNew()) {
      mapper.insertAndGetId(config);
    } else {
      config.incVersion();
      mapper.update(config);
    }
  }

  @Override
  public Config findById(Long id) {
    return mapper.findById(id);
  }

  @Override
  @Cacheable(value = NAME, unless = "#result == null")
  public List<Config> findAll() {
    return mapper.findAll();
  }

  @Override
  @CacheEvict(value = NAME, allEntries = true)
  public void clearCache() {
  }

  @Override
  public void delete(Config config) {
    if (config != null) {
      config.setContent("#deletedBy " + config.getEditor()); //标识为被删除
      config.incVersion();
      mapper.deleteById(config.getId());
    }
  }

  @Override
  public void updatePath(String path, Long id) {
    mapper.updatePath(path, id);
  }
}

