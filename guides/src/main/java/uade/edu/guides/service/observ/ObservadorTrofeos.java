package uade.edu.guides.service.observ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;

@Component
@RequiredArgsConstructor
public class ObservadorTrofeos implements IObserver {

    private final ProfileRepository profileRepository;

    private final ProfileMapper mapper;

    @Override
    public void addTrophyProfile(Profile profile, TrophyDTO trophyDto) {
        Trophy newTrophy = mapper.toTrophy(trophyDto);
        newTrophy.setProfile(profile);

        List<Trophy> trophies = profile.getTrophies();

        if (trophies == null) {
            trophies = new ArrayList<>();
            profile.setTrophies(trophies);
        }

        trophies.add(newTrophy);

        profileRepository.save(profile);
    }

}