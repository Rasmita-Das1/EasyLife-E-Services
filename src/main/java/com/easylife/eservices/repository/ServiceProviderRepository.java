package com.easylife.eservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easylife.eservices.model.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long>{
	
	List<ServiceProvider> findAllByCategory(String category);
	
	List<ServiceProvider> findAllByLocation(String location);
	
	List<ServiceProvider> findAllByCost(int cost);

}
