package uade.edu.guides.service.credent;
package uade.edu.guides.service.auth.adapters;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;

@Component

public class VerificadorIA implements IAdapterIA {
    @Override
    public boolean verifyCredential(String credentialId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticarUsuario'");
    }
}