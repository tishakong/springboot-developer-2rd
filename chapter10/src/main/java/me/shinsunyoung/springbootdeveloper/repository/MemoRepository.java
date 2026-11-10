package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 등록순/최신순 정렬을 위한 쿼리 메소드
    List<Memo> findAllByOrderByIdDesc();
}