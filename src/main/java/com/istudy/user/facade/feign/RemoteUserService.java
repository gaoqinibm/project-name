package com.istudy.user.facade.feign;

import com.istudy.user.facade.feign.factory.RemoteUserFallbackFactory;
import com.istudy.user.facade.vo.SysUserVO;
import com.istudy.user.constant.ServiceNameConstants;
import com.rocky.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户 Feign服务层
 *
 * @author Baizhen
 * @date 2019-05-20
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {

    @PostMapping("user/getUserInfo")
    SysUserVO selectSysUserByUserId(long userId);

    @GetMapping("user/findByUserName/{userName}")
    SysUserVO selectSysUserByUserName(@PathVariable("userName") String userName);

    @PostMapping("user/update/login")
    R updateUserLoginRecord(@RequestBody SysUserVO user);

}
