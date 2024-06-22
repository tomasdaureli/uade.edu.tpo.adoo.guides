package uade.edu.guides.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT g FROM Guide g WHERE g.id = :id AND TYPE(g) = Guide")
    Optional<Guide> findByIdAndProfileType(@Param("id") Long id);

    @Query("SELECT g FROM Guide g WHERE TYPE(g) = Guide")
    List<Guide> findByProfileType();

    @Query("SELECT g FROM Guide g WHERE g.id = :id")
    Profile findProfileByID(@Param("id") Long id);

}
