package uade.edu.guides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByGuide(Guide guide);

}
