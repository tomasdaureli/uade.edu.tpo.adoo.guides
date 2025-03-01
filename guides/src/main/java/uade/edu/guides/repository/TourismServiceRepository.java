package uade.edu.guides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.TourismService;

@Repository
public interface TourismServiceRepository extends JpaRepository<TourismService, Long> {

}
