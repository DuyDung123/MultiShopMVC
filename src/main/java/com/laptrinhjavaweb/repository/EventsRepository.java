package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.EventsEntity;

public interface EventsRepository extends JpaRepository<EventsEntity, Long> {

}
