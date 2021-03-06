package io.lao.alloutjpa.service.converter;

import io.lao.alloutjpa.dao.JpaBook;
import io.lao.alloutjpa.model.Book;
import io.lao.alloutjpa.view.BookView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookConverterImpl implements BookConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookConverterImpl.class);

    @Override
    public Book viewToBook(BookView bookView) {
        if (bookView != null) {
            LOGGER.info("Converting BookView to domain success!");
            return new Book(bookView.getId(), bookView.getName(), bookView.getGenre());
        } else {
            LOGGER.warn("Converting BookView to domain failed.");
            return null;
        }

    }

    @Override
    public BookView bookToView(Book book) {
        if (book != null) {
            LOGGER.info("Converting Book to BookView success!");
            return new BookView(book.getId(), book.getName(), book.getGenre());
        } else
            return null;
    }

    @Override
    public JpaBook bookToJpaBook(Book book) {
        if (book != null) {
            JpaBook jpaBook = new JpaBook();
            jpaBook.setName(book.getName());
            jpaBook.setGenre(book.getGenre());
            jpaBook.setId(book.getId());
            LOGGER.info("Converting Book to JpaBook success!");
            return jpaBook;
        } else {
            LOGGER.warn("Converting Book to JpaBook failed.");
            return null;
        }

    }

    @Override
    public Book jpaBookToBook(JpaBook jpaBook) {
        if (jpaBook != null) {
            LOGGER.info("Converting JpaBook to Book success!");
            return new Book(jpaBook.getId(), jpaBook.getName(), jpaBook.getGenre());
        } else
            return null;
    }
}
