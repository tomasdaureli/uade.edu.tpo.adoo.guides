package uade.edu.guides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
