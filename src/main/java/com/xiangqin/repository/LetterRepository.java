package com.xiangqin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiangqin.domain.Letter;

public interface LetterRepository extends JpaRepository<Letter, Integer> {

	@Query(value = "select t.* from t_letter t where t.from_id= :fromId", nativeQuery = true)
	List<Letter> list(@Param("fromId") Integer fromId);
}
