package com.xjx.production.controller.sts;

import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.xjx.production.base.R;
import com.xjx.production.service.sts.StsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stsOss")
public class StsOssController {

    @Autowired
    StsService stsService;

    @ApiOperation(value = "通过sts获取oss相关认证信息", notes = "通过sts获取oss相关认证信息")
    @GetMapping("/obtainAuthInfo")
    public R<AssumeRoleResponse> obtainAuthInfo() {
        return R.ok(stsService.obtainAuthInfo());
    }

}
