package uade.edu.guides.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.service.ServiceService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @PostMapping
    public ServiceDTO addService(
            @RequestBody CreateServiceDTO request) {
        return service.createService(request);
    }

    @PatchMapping("/{serviceId}")
    public ServiceDTO updateService(
            @PathVariable Long serviceId,
            @RequestBody UpdateServiceDTO request) {
        return service.updateService(request);
    }

    @DeleteMapping("/{serviceId}")
    public void deleteService(
            @PathVariable Long serviceId) {
        service.deleteService(serviceId);
    }

    @GetMapping
    public ServiceDTO getServiceByName(
            @RequestParam String serviceName) {
        return service.getServiceByName(serviceName);
    }

    @GetMapping
    public List<ServiceDTO> getAllServices() {
        return service.getAllServices();
    }

    @GetMapping("/{serviceId}")
    public ServiceDTO getServiceById(
            @PathVariable Long serviceId) {
        return service.getServiceById(serviceId);
    }

}
