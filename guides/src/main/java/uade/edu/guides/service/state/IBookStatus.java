package uade.edu.guides.service.state;

import uade.edu.guides.entity.Book;

public interface IBookStatus {

    void sendTouristNotification(Book book);

    void acceptBook(Book book);

    void cancelBook(Book book);

    String getStatus();

}
