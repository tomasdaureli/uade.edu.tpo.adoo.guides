package uade.edu.guides.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.entity.TourismService;
import uade.edu.guides.exception.TourismServiceNotFoundException;
import uade.edu.guides.mapper.TourismServiceMapper;
import uade.edu.guides.repository.TourismServiceRepository;
import uade.edu.guides.service.TourismServiceService;

@Service
@RequiredArgsConstructor
public class TourismServiceServiceImpl implements TourismServiceService {

    private final TourismServiceRepository repository;

    private final TourismServiceMapper mapper;

    @Override
    public ServiceDTO createService(CreateServiceDTO request) {
        TourismService newService = mapper.toServiceFromCreateDTO(request);
        return mapper.toServiceDTO(repository.save(newService));
    }

    @Override
    public ServiceDTO updateService(Long serviceId, UpdateServiceDTO request) {
        TourismService service = repository.findById(serviceId)
                .orElseThrow(TourismServiceNotFoundException::new);

        service = mapper.toServiceFromUpdateDTO(request, service);

        return mapper.toServiceDTO(repository.save(service));
    }

    @Override
    public void deleteService(Long serviceId) {
        TourismService service = repository.findById(serviceId)
                .orElseThrow(TourismServiceNotFoundException::new);

        repository.delete(service);
    }

    @Override
    public ServiceDTO getServiceById(Long serviceId) {
        TourismService service = repository.findById(serviceId)
                .orElseThrow(TourismServiceNotFoundException::new);

        return mapper.toServiceDTO(service);
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return repository.findAll().stream()
                .map(mapper::toServiceDTO)
                .toList();
    }

}
