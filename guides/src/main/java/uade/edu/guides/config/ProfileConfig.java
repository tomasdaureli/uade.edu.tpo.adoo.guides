package uade.edu.guides.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.GuideService;
import uade.edu.guides.service.TouristService;
import uade.edu.guides.service.impl.ProfileServiceImpl;
import uade.edu.guides.service.observ.ObservadorNotificacion;
import uade.edu.guides.service.observ.ObservadorTrofeos;

@Component
public class ProfileConfig {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private ProfileMapper profileMapper;

    @Autowired
    private GuideService guideService;

    @Autowired
    private TouristService touristService;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ObservadorNotificacion observadorNotificacion;

    @Autowired
    private ObservadorTrofeos observadorTrofeos;

    @Bean
    public ProfileServiceImpl creatProfileConfig() {
        return new ProfileServiceImpl(repository, profileMapper, guideService, touristService, context,
                Arrays.asList(observadorNotificacion, observadorTrofeos));
    }

}
