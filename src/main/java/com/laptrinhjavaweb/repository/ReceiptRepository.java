package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ReceiptEntity;

public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Long> {

}
