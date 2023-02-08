package com.easylife.eservices.service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.easylife.eservices.model.ServiceProvider;

public interface SrvcProviderService {

	List<ServiceProvider> findAllServiceProvider();
	
	ServiceProvider findById(long id);
	
	ServiceProvider save(ServiceProvider srvcProvider);
	
	ServiceProvider update(ServiceProvider srvcProvider);
	
	void deleteById(long id); 
	
	List<ServiceProvider> findByCategory(String category);
	
	List<ServiceProvider> findByLocation(String location);
	
	List<ServiceProvider> findByCost(int cost);
	
//	List<ServiceProvider> findServiceProviderCustomSortedByCost(Direction direction);

	Page<ServiceProvider> findServiceProviderCustomSortedByCost(int pageNum, int recordsNum, Direction direction);
	
}
