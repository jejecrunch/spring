package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer>  {

	// 교수를 삭제하기 전에, 담당 과목이 있는지 조회하기 위한 메소드
    int countByProfessorId(int professorId);
}

