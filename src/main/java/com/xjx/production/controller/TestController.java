package com.xjx.production.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.base.R;
import com.xjx.production.dto.product.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.service.product.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


/**
 * <p>
 * Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  PasswordEncoder passwordEncoder;

  @ApiOperation(value = "测试", notes = "测试")
  @GetMapping("/out")
  //@RolesAllowed("ROLE_admin")
  public R<String> out(@RequestParam String rawPwd) {
    return R.ok(passwordEncoder.encode(rawPwd));
  }
}
