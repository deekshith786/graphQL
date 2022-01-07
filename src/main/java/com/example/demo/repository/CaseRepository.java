package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Case;

public interface CaseRepository extends JpaRepository<Case, String> {

}
