package uade.edu.guides.service.observ;

import uade.edu.guides.domain.TrophyDTO;

public interface IObserver {

    void addTrophyGuide(Long guideId, TrophyDTO trophyDto);

}