package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;

public interface TourismServiceService {

    ServiceDTO createService(CreateServiceDTO request);

    ServiceDTO updateService(Long serviceId, UpdateServiceDTO request);

    void deleteService(Long serviceId);

    ServiceDTO getServiceById(Long serviceId);

    List<ServiceDTO> getAllServices();

}
