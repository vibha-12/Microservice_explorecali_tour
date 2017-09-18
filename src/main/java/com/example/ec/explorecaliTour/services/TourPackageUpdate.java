package com.example.ec.explorecaliTour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.explorecaliTour.domain.TourPackage;
import com.example.ec.explorecaliTour.repo.TourPackageRepository;

@RestController
@RequestMapping(path="/tours/packages/{code}/{name}")
public class TourPackageUpdate {
	@Autowired
	private TourPackageRepository tourPackageRepository;
	
	
	@GetMapping
	public String chkTour(@PathVariable(value="code") String code,@PathVariable(value="name") String name)
	{
		
		tourPackageRepository.save(new TourPackage(code,name));
		return "saved";
	}


}
