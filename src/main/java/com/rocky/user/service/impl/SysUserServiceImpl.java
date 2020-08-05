package com.rocky.user.service.impl;

import com.rocky.common.utils.OrikaMapperUtils;
import com.rocky.user.domain.SysUser;
import com.rocky.user.facade.vo.SysUserVO;
import com.rocky.user.mapper.SysUserMapper;
import com.rocky.user.service.ISysUserService;
import com.rocky.user.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author Baizhen
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper       userMapper;

    /**
     * 根据条件分页查询用户列表
     * 
     * @param userVO 用户信息
     * @return 用户信息集合信息
     */
    @Override
    public List<SysUserVO> selectUserList(SysUserVO userVO) {
        SysUser sysUser = OrikaMapperUtils.map(userVO, SysUser.class);
        List<SysUser> sysUserList = userMapper.selectUserList(sysUser);
        return OrikaMapperUtils.mapList(sysUserList, SysUser.class, SysUserVO.class);
    }

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public Result<SysUserVO> selectUserByLoginName(String userName) {
        SysUser sysUser = userMapper.selectUserByLoginName(userName);
        SysUserVO sysUserVO = OrikaMapperUtils.map(sysUser, SysUserVO.class);
        return new Result<>(sysUserVO);
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public Result<SysUserVO> selectUserById(Long userId) {
        SysUser sysUser = userMapper.selectUserById(userId);
        SysUserVO sysUserVO = OrikaMapperUtils.map(sysUser, SysUserVO.class);
        return new Result<>(sysUserVO);
    }
}
