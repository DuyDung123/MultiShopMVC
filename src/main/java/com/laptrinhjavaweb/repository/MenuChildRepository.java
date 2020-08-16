package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.MenuChildEntity;


public interface MenuChildRepository extends JpaRepository<MenuChildEntity, Long> {
	
	@Query(value = "select * from menudad as dad inner join menuchild as child on dad.id = child.menudadid where dad.id = 1",nativeQuery = true)
	List<MenuChildEntity> findAllByDadid();
	
}
