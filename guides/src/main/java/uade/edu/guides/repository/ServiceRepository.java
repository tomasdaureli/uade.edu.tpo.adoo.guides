package uade.edu.guides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
