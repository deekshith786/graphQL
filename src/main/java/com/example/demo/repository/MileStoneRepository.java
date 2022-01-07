package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Milestone;

public interface MileStoneRepository extends JpaRepository<Milestone, String> {

}
