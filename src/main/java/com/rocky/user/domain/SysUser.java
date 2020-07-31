package com.rocky.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户对象 sys_user
 * 
 * @author Baizhen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {

    /** 用户ID */
    private Long              userId;

    /** 登录名称 */
    private String            loginName;

    /** 用户名称 */
    private String            userName;

    /** 用户类型（00系统用户）**/
    private String            userType;

    /** 用户邮箱 */
    private String            email;

    /** 手机号码 */
    private String            phoneNumber;

    /** 用户性别 */
    private Byte            sex;

    /** 用户头像 */
    private String            avatar;

    /** 密码 */
    private String            password;

    /** 盐加密 */
    private String            salt;

    /** 帐号状态（0正常 1停用） */
    private Byte            status;

    /** 删除标志（0代表存在 2代表删除） */
    private Byte            delFlag;

    /** 最后登陆IP */
    private String            loginIp;

    /** 最后登陆时间 */
    private Date              loginDate;

    private Date createTime;

    private Date updateTime;

}
