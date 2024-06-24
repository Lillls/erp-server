package com.xjx.production.dto.user;

import com.xjx.production.entity.sys.Role;
import com.xjx.production.entity.user.UmsMember;
import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class MemberDetails implements UserDetails {

    public final UmsMember umsMember;

    public final List<SimpleGrantedAuthority> roleNames;

    public final List<MenuDto> menuDtoList;

    public MemberDetails(UmsMember umsMember, List<String> roleNames, List<MenuDto> menuDtoList){
        this.umsMember = umsMember;
        this.roleNames = convertAuthority(roleNames);
        this.menuDtoList = menuDtoList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleNames;
    }

    @Override
    public String getPassword() {
        return umsMember.getPassword();
    }

    @Override
    public String getUsername() {
        return umsMember.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return umsMember.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return umsMember.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return umsMember.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return umsMember.getEnable();
    }

    public static List<SimpleGrantedAuthority> convertAuthority( List<String> roleNames){
        List<SimpleGrantedAuthority> list = new ArrayList<>(roleNames.size());
        if(!CollectionUtils.isEmpty(roleNames)){
            roleNames.forEach(item -> list.add(new SimpleGrantedAuthority(item)));
        }
        return list;
    }
}
