package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, String> {

}
