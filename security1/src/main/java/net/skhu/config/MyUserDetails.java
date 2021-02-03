package net.skhu.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.skhu.entity.User;

@Data
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    // Spring Security에 필요한 필수 요소
    // 멤버 변수들의 getter가 반드시 있어야 함
    final boolean accountNonExpired = true;
    final boolean accountNonLocked = true;
    final boolean credentialsNonExpired = true;
    final String password;
    final String username;
    final boolean isEnabled;
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    // -------------------------------

    // bbs2 테이블의 user 테이블에 name, email, userType, admin 필드에 해당하는 멤버 변수
    final String name;
    final String email;
    final String userType;
    final boolean admin;
    // -------------------------------

    public MyUserDetails(User user) {
        // Spring Security에 필요한 필수 요소
        switch (user.getUserType()) {
        // authorities 멤버 변수의 값 : 사용자 권한 목록
        // 권한 목록에 권한 추가
        case "교수": authorities.add(new SimpleGrantedAuthority("ROLE_PROFESSOR")); break;
        case "학생": authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT")); break;
        }
        // user 객체의 admin 속성 값 tf 검사해서 권한 추가
        if (user.isAdmin()) authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        this.username = user.getUserid();
        this.password = user.getPassword();
        this.isEnabled = user.isEnabled();
        // ----------------------------------------

        // bbs2 테이블의 user 테이블에 name, email, userType, admin 필드에 해당하는 멤버 변수
        this.name = user.getName();
        this.email = user.getEmail();
        this.userType = user.getUserType();
        this.admin = user.isAdmin();
        // -----------------------------------
    }
}

