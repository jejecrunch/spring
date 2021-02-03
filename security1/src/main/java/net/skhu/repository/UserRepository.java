package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	// User 테이블에서 userid 필드로 레코드를 조회하는 메소드
    User findByUserid(String userid);

}
