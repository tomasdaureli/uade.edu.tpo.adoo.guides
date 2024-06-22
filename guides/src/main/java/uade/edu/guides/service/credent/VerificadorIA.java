package uade.edu.guides.service.credent;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VerificadorIA implements IAdapterIA {

    @Override
    public Boolean verifyCredential(String credentialId) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                log.info("Credencial válida: {}", credentialId);
                return true;
            case 1:
                log.info("Credencial inválida: {}", credentialId);
                return false;
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }


}