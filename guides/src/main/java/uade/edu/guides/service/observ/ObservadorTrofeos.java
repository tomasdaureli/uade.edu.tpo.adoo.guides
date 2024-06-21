package uade.edu.guides.service.observ;

import org.springframework.stereotype.Component;

import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Trophy;

@Component
public class ObservadorTrofeos implements IObserver {

    @Override
    public void addTrophy(Guide guideDto, Trophy trophyDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTrophy'");
    }

}