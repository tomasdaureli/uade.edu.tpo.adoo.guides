package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;

public interface ServiceService {

    ServiceDTO createService(CreateServiceDTO request);

    ServiceDTO updateService(UpdateServiceDTO request);

    void deleteService(Long serviceId);

    ServiceDTO getServiceById(Long serviceId);

    ServiceDTO getServiceByName(String serviceName);

    List<ServiceDTO> getAllServices();

}
