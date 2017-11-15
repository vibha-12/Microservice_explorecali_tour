package com.example.ec.explorecaliTour.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.explorecaliTour.domain.Tour;
import com.example.ec.explorecaliTour.domain.TourPackage;
import com.example.ec.explorecaliTour.repo.TourRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping(path="/tours/{tourPkgCode}")
public class TourController {
	TourRepository tourRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public TourController(TourRepository tourRepository) {
		super();
		
		this.tourRepository = tourRepository;
	}
	public TourController(){
		
	}
	
	@HystrixCommand(fallbackMethod="fallback2")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity < String > createTour(@PathVariable(value="tourPkgCode") String tourPkgCode,@RequestBody TourDto tourDto)
	{
		String url="http://explorecali/rest/hello/tourChk/"+tourPkgCode;
		String abc;
		abc= restTemplate.getForObject(url,String.class);
		String tourPkgName=verifyTourPkg(abc);
		TourPackage tourPk=new TourPackage(tourPkgCode,tourPkgName);
		int i=tourDto.getId();
		String url1="http://explorecali/tourAdd/"+tourPkgCode+"/"+tourPkgName+"/"+i+"/"+tourDto.getTitle()+"/"+tourDto.getDescription()+"/"+tourDto.getBlurb()+"/"+tourDto.getPrice()+"/"+tourDto.getBullets()+"/"+tourDto.getDuration()+"/"+tourDto.getKeywords()+"/"+tourDto.getDifficulty()+"/"+tourDto.getRegion();
		String abc1;
		abc1= restTemplate.getForObject(url1,String.class);
		System.out.println("");
		//tourRatingService.createTourPkg(tour,tourId,ratingDto,tourRatingRepository);
		 tourRepository.save(new Tour(tourDto.getId(),tourDto.getTitle(),tourDto.getDescription(),tourDto.getBlurb(),tourDto.getPrice(),tourDto.getBullets(),tourDto.getDuration(),tourDto.getKeywords(),tourPk,tourDto.getDifficulty(),tourDto.getRegion()));
	 return ResponseEntity.status(HttpStatus.CREATED).build();	
		
	}
	
	public ResponseEntity<String> fallback2(String tourPkgCode,TourDto tourDto)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	private String verifyTourPkg(String abc) throws NoSuchElementException

	{
	//Tour tour=tourRepository.findOne(tourId);
	if(abc.equals(null)){
		throw new NoSuchElementException("This Tour Package does not exists");
	}
	return abc;

	}

	
	@RequestMapping(method=RequestMethod.GET)
	public List<Tour> getAllTour(@PathVariable(value="tourPkgCode")String tourPkgCode)
	{
		//verifyTour(tourId);
		return tourRepository.findByTourPackageCode(tourPkgCode);
	}

	
	
	
}
