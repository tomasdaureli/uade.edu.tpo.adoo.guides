package uade.edu.guides.service.chat;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.entity.Book;

@Slf4j
@Component
public class SendBird implements IAdapterSendBird {

    @Override
    public void enableChat(Book book) {
        log.info("Sistema de mensajeria activado en la reserva Nº" + book.getId());
    }

}
