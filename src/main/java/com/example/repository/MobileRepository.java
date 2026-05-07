package com.example.repository;

import com.example.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile,Long> {
}
