package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true, jsr250Enabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 앞에서 구현한 MyUserDetailsService 클래스 객체가 하나 자동으로 생성되어서,
	// userDetailsService 멤버 변수에 자동으로 주입(autowired)된다.
    @Autowired UserDetailsService userDetailsService;

    // @Bean의 기능 : 이 프로젝트의 다른 클래스에서
    // @Autowired PasswordEncoder passwordEncoder; 선언이 있으면
    // 이 메소드가 리턴하는 객체가 자동으로 주입(autowired)된다.

    @Bean
    // 비밀번호 인코딩 객체를 생성해서 리턴하는 메소드
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// 로그인한 사용자 정보를 조회할 때 userDetailsService 객체를 사용하라고 설정.
    	auth.userDetailsService(userDetailsService)
    	// passwordEncoder() 메소드가 리턴하는 객체를 사용하여, 비밀번호를 암호화하라는 선언.
            .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    	// /res/** 패턴의 URL은 보안 검사하지 말고 무시하라는 설정
    	web.ignoring().antMatchers("/res/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 권한 설정 시작
    	http.authorizeRequests()
    		// /admin/** 패턴의 URL은 ROLE_ADMIN 권한을 소유한 사용자만 요청할 수 있다는 설정
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            // /professor/** 패턴의 URL은 ROLE_PROFESSOR 권한을 소유한 사용자만 요청할 수 있다는 설정
            .antMatchers("/professor/**").access("hasRole('ROLE_PROFESSOR')")
            // /user/** 패턴의 URL은 로그인된 사용자에게만 허용된다는 설정
            .antMatchers("/user/**").authenticated();

    	// 로그인 페이지 설정 시작
        http.formLogin()
        	// 로그인 페이지 URL 설정
            .loginPage("/login")
            // 로그인 페이지에서 '로그인' 버튼(submit button)을 눌렀을 때 요청할 URL 설정
            // 이 URL이 요청되면
            // spring security 엔진이 MyAuthenficationProvider의 authenticate 메소드를 호출하여 로그인 검사를 수행함.
            .loginProcessingUrl("/login_processing")
            // 로그인이 실패했을 때 redirect될 URL 설정
            .failureUrl("/login?error")
            // 로그인이 성공했을 때 redirect될 URL 지정
            // true일 때 1st param URL로 넘어감
            // false일 때 로그인하기 직전에 방문하려던 페이지가 있으면 그 페이지로 넘어가고
            //	                         		없을 때만, 1st param URL로 넘어감
            .defaultSuccessUrl("/user/redirect", true)
            //.defaultSuccessUrl("/", true)
            // 로그인 뷰 파일에서 로그인 아이디 input 태그의 name값과,
            .usernameParameter("userid")
            // 					비밀번호 input 태그의 name값 설정
            .passwordParameter("passwd");

        // 로그아웃 설정 시작
        http.logout()
        	// 로그아웃 버튼이나 링크를 눌렀을 때 요청할 URL 설정
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout_processing"))
            // 로그아웃된 후 redirect될 URL 설정
            .logoutSuccessUrl("/login")
            // 로그아웃할 때, 세션에 들어있는 데이터를 모두 지우라는 설정
            .invalidateHttpSession(true);
    }

}

