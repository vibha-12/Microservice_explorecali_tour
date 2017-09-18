package com.example.ec.explorecaliTour.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ec.explorecaliTour.controller.TourDto;
import com.example.ec.explorecaliTour.domain.Tour;


public interface TourRepository extends CrudRepository<Tour,Integer> {
List<Tour> findByTourPackageCode(@Param("code")String code);


}
