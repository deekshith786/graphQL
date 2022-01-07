package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, String> {

}
