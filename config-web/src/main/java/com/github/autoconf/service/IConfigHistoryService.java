package com.github.autoconf.service;

import com.github.autoconf.entity.ConfigHistory;

import java.util.List;

/**
 * 获取历史记录
 *
 * Created by huangxiaofengsi1752 on 2015/2/9.
 */
public interface IConfigHistoryService {

  List<ConfigHistory> findRecent();

  List<ConfigHistory> findByEditor(String editor);

  List<ConfigHistory> findByConfigId(long configId);

  List<ConfigHistory> findByConfigIdAndEditor(long configId, String editor);

  List<ConfigHistory> findAll();

  void clearCache();

  void insert(ConfigHistory history);

  ConfigHistory findbyId(long id);
}
