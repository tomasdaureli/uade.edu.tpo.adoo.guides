package uade.edu.guides.service.observ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.exception.GuideNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;

@Component
@RequiredArgsConstructor
public class ObservadorTrofeos implements IObserver {

    private final ProfileRepository profileRepository;
    private final ProfileMapper mapper;

    @Override
    public void addTrophyGuide(Long guideId, TrophyDTO trophyDto) {
       Guide guide = profileRepository.findByIdAndProfileType(guideId)
                .orElseThrow(GuideNotFoundException::new);

        Trophy newTrophy = mapper.toTrophy(trophyDto);

        List<Trophy> trophies = guide.getTrophies();

        if (trophies == null) {
            trophies = new ArrayList<>();
            guide.setTrophies(trophies);
        }

        trophies.add(newTrophy);

        profileRepository.save(guide);
    }

}