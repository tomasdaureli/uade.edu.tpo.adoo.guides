package uade.edu.guides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

}