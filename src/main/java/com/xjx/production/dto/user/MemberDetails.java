package com.xjx.production.dto.user;

import com.xjx.production.entity.user.UmsMember;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class MemberDetails implements UserDetails {

    public UmsMember umsMember;

    public MemberDetails(UmsMember umsMember){
        this.umsMember = umsMember;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}
