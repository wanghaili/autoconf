package com.github.autoconf.service;

import com.github.autoconf.entity.User;

import java.util.List;

/**
 * 用户相关服务
 * Created by harry on 2015-10-04 18:17.
 */
public interface IUserService {

  User findByUsername(String username);

  void create(User user);

  void updateAuthentication(User user);

  void updatePassword(User user);

  List<User> findAll();

  void lock(String username);

  void updateLoginTime(String username);

  List<User> findNotLoginAfter(String day);
}
