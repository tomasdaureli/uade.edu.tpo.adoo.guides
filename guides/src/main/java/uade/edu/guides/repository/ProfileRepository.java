package uade.edu.guides.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Tourist;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT g FROM Guide g WHERE g.id = :id AND TYPE(g) = Guide")
    Optional<Guide> findGuideById(@Param("id") Long id);

    @Query("SELECT t FROM Tourist t WHERE t.id = :id AND TYPE(t) = Tourist")
    Optional<Tourist> findTouristById(@Param("id") Long id);

    @Query("SELECT g FROM Guide g WHERE TYPE(g) = Guide")
    List<Guide> findByProfileType();

}
