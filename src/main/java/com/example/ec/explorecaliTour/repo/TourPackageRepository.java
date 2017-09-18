package com.example.ec.explorecaliTour.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ec.explorecaliTour.domain.TourPackage;


public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
	TourPackage findByName(@Param("name")String name);
}
