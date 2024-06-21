package uade.edu.guides.service.credent;

//import uade.edu.guides.domain.AuthenticateUserDTO;

public interface IAdapterAutenticacionExterna {
    boolean verifyCredential(String credentialId);
}