package com.easylife.eservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easylife.eservices.model.ServiceProvider;
import com.easylife.eservices.service.SrvcProviderService;


@RestController
@RequestMapping("/easylife/eservices")
public class SrvcProviderController {
	
	@Autowired
	private SrvcProviderService srvcProviderService;
	
	
	@GetMapping
	List<ServiceProvider> listAllServiceProvider(){
		return srvcProviderService.findAllServiceProvider();
	}
	
	
	@GetMapping("/{srvcProviderId}")
	public ServiceProvider findServiceProviderById(@PathVariable("srvcProviderId") long id) {
		return srvcProviderService.findById(id);		
	}
	
	
	@PostMapping
	public ServiceProvider saveServiceProvider(@RequestBody ServiceProvider srvcProvider) {
		return srvcProviderService.save(srvcProvider);
	}
	
	
	public ServiceProvider updateServiceProvider(@RequestBody ServiceProvider srvcProvider) {
		return srvcProviderService.update(srvcProvider);
	}
	

	@DeleteMapping("/{srvcProviderId}")
	public String deleteServiceProviderById(@PathVariable("srvcProviderId") long id) {
		srvcProviderService.deleteById(id);
		return "Service Provider Deleted with id : " + id;
	}
	
	@GetMapping("/{srvcProviderCategory}")
	public List<ServiceProvider> findServiceProviderByCategory(@PathVariable("srvcProviderCategory") String category) {
		return srvcProviderService.findByCategory(category);		
	}
	
	@GetMapping("/{srvcProviderLocation}")
	public List<ServiceProvider> findServiceProviderByLocation(@PathVariable("srvcProviderLocation") String location) {
		return srvcProviderService.findByLocation(location);		
	}
	
	@GetMapping("/{srvcProviderCost}")
	public List<ServiceProvider> findServiceProviderByCost(@PathVariable("srvcProviderCost") int cost) {
		return srvcProviderService.findByCost(0);		
	}
	
//	@GetMapping("/{srvcProviderId}")
//	public List<ServiceProvider> findServiceProviderCustomSortedByCost(Direction order) {
//		return srvcProviderService.findServiceProviderCustomSortedByCost(order);
//	}
	
	
	/*
	 * findServiceProviderCustomSortedByCost
	 */
	

	
	
	
	
	

}
