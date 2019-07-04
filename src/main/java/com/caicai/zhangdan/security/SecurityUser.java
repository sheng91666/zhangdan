package com.caicai.zhangdan.security;

import com.caicai.zhangdan.entity.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser extends UserEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUser(UserEntity user) {
        if (user != null) {
            this.setUserCode(user.getUserCode());
            this.setUserName(user.getUserName());
            this.setPassWord(user.getPassWord());
            this.setEmail(user.getEmail());
            this.setPhone(user.getPhone());
            this.setRole(user.getRole());
            this.setUserImage(user.getUserImage());
            this.setLastIp(user.getLastIp());
            this.setLastTime(user.getLastTime());
        }
    }

    // 用户类型-权限（spring security权限默认会以ROLE_开头，所以注册时候得加上ROLE_）
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<SimpleGrantedAuthority>();
        simpleAuthorities.add(new SimpleGrantedAuthority("ROLE_" + super.getRole()));
        return simpleAuthorities;
    }

    @Override
    public String getPassword() {
        return super.getPassWord();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
