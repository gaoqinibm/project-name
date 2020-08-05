package com.rocky.user.facade.feign.factory;

import com.rocky.common.core.domain.R;
import com.rocky.user.facade.feign.RemoteUserService;
import com.rocky.user.facade.vo.SysUserVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public SysUserVO selectSysUserByUserName(String username)
            {
                return null;
            }

            @Override
            public R updateUserLoginRecord(SysUserVO user) {
                return R.error();
            }

            @Override
            public SysUserVO selectSysUserByUserId(long userId) {
                SysUserVO user = SysUserVO.builder()
                        .userId(0l)
                        .loginName("no user")
                        .build();
                return user;
            }
        };
    }
}
