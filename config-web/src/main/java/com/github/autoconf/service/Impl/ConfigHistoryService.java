package com.github.autoconf.service.Impl;

import com.github.autoconf.entity.ConfigHistory;
import com.github.autoconf.mapper.ConfigHistoryMapper;
import com.github.autoconf.service.IConfigHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取历史记录
 *
 * Created by huangxiaofengsi1752 on 2015/2/9.
 */
@Service("historyService")
public class ConfigHistoryService implements IConfigHistoryService{
  private static final String NAME = "HistoryCache";

  @Autowired
  private ConfigHistoryMapper mapper;

  @Override
  @Cacheable(value = NAME)
  public List<ConfigHistory> findRecent() {
    return mapper.findRecent();
  }

  @Override
  @Cacheable(value = NAME)
  public List<ConfigHistory> findByEditor(String editor) {
    return mapper.findByEditor(editor);
  }

  @Override
  @Cacheable(value = NAME)
  public List<ConfigHistory> findByConfigId(long configId) {
    return mapper.findByConfigId(configId);
  }

  @Override
  @Cacheable(value = NAME)
  public List<ConfigHistory> findByConfigIdAndEditor(long configId, String editor) {
    return mapper.findByConfigIdAndEditor(configId, editor);
  }

  @Override
  @Cacheable(value = NAME)
  public List<ConfigHistory> findAll() {
    return mapper.findAll();
  }

  @Override
  @CacheEvict(value = NAME, allEntries = true)
  public void clearCache() {
  }

  @Override
  @CacheEvict(value = NAME, allEntries = true)
  public void insert(ConfigHistory history) {
    mapper.insert(history);
  }

  @Override
  public ConfigHistory findbyId(long id) {
    return mapper.findById(id);
  }
}
