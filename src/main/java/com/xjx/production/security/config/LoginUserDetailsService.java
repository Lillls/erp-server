package com.xjx.production.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjx.production.dto.user.MemberDetails;
import com.xjx.production.dto.user.MenuDto;
import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.repository.sys.RoleMapper;
import com.xjx.production.repository.user.UmsMemberRepository;
import com.xjx.production.service.sys.MenuService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UmsMemberRepository umsMemberRepository;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    MenuService menuService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 加载用户信息
        if(StringUtils.isEmpty(username)) {
            log.warn("【LoginUserDetailsService】用户登陆用户名为空:{}",username);
            throw new UsernameNotFoundException("用户名不能为空");
        }

        UmsMember umsMember = umsMemberRepository.queryMemberByUserName(username);

        if(null == umsMember) {
            log.warn("【LoginUserDetailsService】根据用户名没有查询到对应的用户信息:{}",username);
            throw new UsernameNotFoundException("没获取到用户");
        }

        log.info("【LoginUserDetailsService】根据用户名:{}获取用户登陆信息:{}",username, new ObjectMapper().writeValueAsString(umsMember));

        List<String> roleList = roleMapper.queryRoleList(umsMember.getId());
        List<MenuDto> menuDtoList = menuService.getMenuWithChild(umsMember.getId(), 0L);

        return new MemberDetails(umsMember, roleList, menuDtoList);
    }
}
