package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.skhu.entity.User;
import net.skhu.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired UserRepository userRepository;

    // spring security가 이 메소드를 통해 사용자 정보 객체를 구하고,
    // 이 메소드가 리던한 MyUserDetails 객체의 pw와 입력된 pw 비교
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// username 로그인 아이디로 사용자를 조회해서
        User user = userRepository.findByUserid(username);

        // 아이디의 사용자를 찾을 수 없으면 not found exception 객체를 throw하고
        if (user == null) throw new UsernameNotFoundException(username);

        // MyUserDetails 사용자 정보 객체를 만들어서 리턴해야 함
        return new MyUserDetails(user);
    }

}

