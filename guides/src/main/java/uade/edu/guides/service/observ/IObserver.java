package uade.edu.guides.service.observ;

import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Trophy;

public interface IObserver {

    void addTrophyGuide(Long guideId, TrophyDTO trophyDto);

}