package com.easylife.eservices.srvcimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.easylife.eservices.model.ServiceProvider;
import com.easylife.eservices.repository.ServiceProviderRepository;
import com.easylife.eservices.service.SrvcProviderService;

@Service
public class SrvcProviderServiceImpl implements SrvcProviderService{
	
	@Autowired
	ServiceProviderRepository srvcProviderRepo;

	@Override
	public List<ServiceProvider> findAllServiceProvider() {
		return srvcProviderRepo.findAll();
	}
	

	@Override
	public ServiceProvider findById(long id) {
		Optional<ServiceProvider> result = srvcProviderRepo.findById(id);
		ServiceProvider srvcProvider = null;

		if (result.isPresent()) {
			srvcProvider = result.get();
		} else {
			//incase we didn't find the employee
			throw new IllegalArgumentException("Did not find employee with id - " + id);
		}
		return srvcProvider;
	}
	

	@Override
	public ServiceProvider save(ServiceProvider srvcProvider) {
		return srvcProviderRepo.save(srvcProvider);
	}
	

	@Override
	public ServiceProvider update(ServiceProvider updatedServiceProvider) {
		// check whether record exists
		Optional<ServiceProvider> result = srvcProviderRepo.findById(updatedServiceProvider.getId());
		ServiceProvider savedServiceProvider = null;

		if (result.isPresent()) {
			savedServiceProvider = result.get();
		} else {
			// we didn't find the employee
			throw new IllegalArgumentException("Did not find employee with id - " + updatedServiceProvider.getId());
		}
		savedServiceProvider.setFirstName(updatedServiceProvider.getFirstName());
		savedServiceProvider.setLastName(updatedServiceProvider.getLastName());
		savedServiceProvider.setContactNum(updatedServiceProvider.getContactNum());
		savedServiceProvider.setLocation(updatedServiceProvider.getLocation());
		savedServiceProvider.setEmail(updatedServiceProvider.getEmail());
		savedServiceProvider.setCost(updatedServiceProvider.getCost());

		return srvcProviderRepo.save(savedServiceProvider);
	}
	
	

	@Override
	public void deleteById(long id) {
		srvcProviderRepo.deleteById(id);
	}

	@Override
	public List<ServiceProvider> findByCategory(String category) {
		return srvcProviderRepo.findAllByCategory(category);
	}

	@Override
	public List<ServiceProvider> findByLocation(String location) {
		return srvcProviderRepo.findAllByLocation(location);
	}

	@Override
	public List<ServiceProvider> findByCost(int cost) {
		return srvcProviderRepo.findAllByCost(cost);
	}

	@Override
	public Page<ServiceProvider> findServiceProviderCustomSortedByCost(int pageNum, int recordsNum,
			Direction direction) {
		Pageable pageable = PageRequest.of(pageNum, recordsNum, direction, "cost");
		return srvcProviderRepo.findAll(pageable);
	}

}
