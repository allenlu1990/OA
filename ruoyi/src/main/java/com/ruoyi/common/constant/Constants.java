package com.ruoyi.common.constant;

import io.jsonwebtoken.Claims;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants {
  /**
   * 通用成功标识
   */
  public static final String SUCCESS = "0";

  /**
   * 通用失败标识
   */
  public static final String FAIL = "1";

  /**
   * 登录成功
   */
  public static final String LOGIN_SUCCESS = "Success";

  /**
   * 注销
   */
  public static final String LOGOUT = "Logout";

  /**
   * 登录失败
   */
  public static final String LOGIN_FAIL = "Error";

  /**
   * 验证码 redis key
   */
  public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

  /**
   * 登录用户 redis key
   */
  public static final String LOGIN_TOKEN_KEY = "login_tokens:";

  /**
   * 验证码有效期（分钟）
   */
  public static final Integer CAPTCHA_EXPIRATION = 2;

  /**
   * 令牌
   */
  public static final String TOKEN = "token";

  /**
   * 令牌前缀
   */
  public static final String TOKEN_PREFIX = "Bearer ";

  /**
   * 令牌前缀
   */
  public static final String LOGIN_USER_KEY = "login_user_key";

  /**
   * 用户ID
   */
  public static final String JWT_USERID = "userid";

  /**
   * 用户名称
   */
  public static final String JWT_USERNAME = Claims.SUBJECT;

  /**
   * 用户头像
   */
  public static final String JWT_AVATAR = "avatar";

  /**
   * 创建时间
   */
  public static final String JWT_CREATED = "created";

  /**
   * 用户权限
   */
  public static final String JWT_AUTHORITIES = "authorities";

  /**
   * 资源映射路径 前缀
   */
  public static final String RESOURCE_PREFIX = "/profile";

  /**
   * 绩效测评下属 rank
   **/
  public static final Integer SUBORDINATES_RANK = 1;

  /**
   * 绩效测评下属 rank
   **/
  public static final Integer LEADER_SUBORDINATES_RANK = 2;

  /**
   * 绩效测评下属 rank
   **/
  public static final Integer LEADER_RANK = 3;

  /**
   * 绩效测评下属 rank
   **/
  public static final Integer LEADER_LEADER_RANK = 4;

  /**
   * 绩效测评默认分数为100
   **/
  public static final double DEFAULT_SCORE = 100.0;

}
