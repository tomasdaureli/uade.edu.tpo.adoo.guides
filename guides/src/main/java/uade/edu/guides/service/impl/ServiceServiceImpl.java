package uade.edu.guides.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.repository.ServiceRepository;
import uade.edu.guides.service.ServiceService;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Override
    public ServiceDTO createService(CreateServiceDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createService'");
    }

    @Override
    public ServiceDTO updateService(UpdateServiceDTO request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateService'");
    }

    @Override
    public void deleteService(Long serviceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteService'");
    }

    @Override
    public ServiceDTO getServiceById(Long serviceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServiceById'");
    }

    @Override
    public ServiceDTO getServiceByName(String serviceName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServiceByName'");
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllServices'");
    }

}
