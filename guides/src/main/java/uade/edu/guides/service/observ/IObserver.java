package uade.edu.guides.service.observ;

import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.entity.Guide;

public interface IObserver {

    void addTrophyGuide(Guide guide, TrophyDTO trophyDto);

}