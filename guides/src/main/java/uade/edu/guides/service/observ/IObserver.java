package uade.edu.guides.service.observ;

import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.entity.Profile;

public interface IObserver {

    void addTrophyProfile(Profile profile, TrophyDTO trophyDto);

}