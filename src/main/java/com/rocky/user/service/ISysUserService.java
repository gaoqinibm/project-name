package com.rocky.user.service;

import com.rocky.user.facade.vo.SysUserVO;
import com.rocky.user.utils.Result;

import java.util.List;

/**
 * 用户 业务层
 *
 * @author Baizhen
 */
public interface ISysUserService {
    /**
     * 根据条件分页查询用户列表
     *
     * @param userVO 用户信息
     * @return 用户信息集合信息
     */
    List<SysUserVO> selectUserList(SysUserVO userVO);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    Result<SysUserVO> selectUserByLoginName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    Result<SysUserVO> selectUserById(Long userId);

}
