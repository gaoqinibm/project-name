package com.istudy.user.controller;

import com.istudy.user.facade.vo.SysUserVO;
import com.istudy.user.service.ISysUserService;
import com.istudy.user.utils.Result;
import com.rocky.common.core.controller.BaseController;
import com.rocky.common.core.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户 提供者
 *
 * @author Baizhen
 * @date 2019-05-20
 */
@RestController
@RequestMapping("user")
@Api(value="用户controller",tags={"用户相关接口"})
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 根据userId查询用户
     */
    @PostMapping("getUserInfo")
    @ApiOperation(value = "查询用户", notes = "查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", required = true)})
    public Result<SysUserVO> getUserInfo(Long userId) {
        if (userId == null){
            return new Result<>("150", "入参错误", null); //测试验证
        }
        return sysUserService.selectUserById(userId);
    }

    /**
     * 根据登录名查询用户
     */
    @GetMapping("findByUserName/{userName}")
    @ApiOperation(value = "根据登录名查询用户", notes = "根据登录名查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户登录名", required = true)})
    public Result<SysUserVO> selectSysUserByUserName(@PathVariable("userName") String userName) {
        return sysUserService.selectUserByLoginName(userName);
    }

    /**
     * 查询用户列表
     */
    @GetMapping("list")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "sysUser", value = "用户信息", required = true)})
    public R list(SysUserVO sysUserVO) {
        startPage();
        return result(sysUserService.selectUserList(sysUserVO));
    }

}
