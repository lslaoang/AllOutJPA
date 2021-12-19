package io.lao.alloutjpa.service.bookreposervice;

import com.sun.istack.NotNull;
import io.lao.alloutjpa.dao.JpaBook;
import io.lao.alloutjpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookRepoServiceImpl implements BookRepoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepoServiceImpl.class);
    final BookRepository bookRepository;

    public BookRepoServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<JpaBook> getAllBooks() {
        LOGGER.info("Retrieving books.");
        return bookRepository.findAll();
    }

    @Override
    public JpaBook findBookById(String id) {
        Optional<JpaBook> book = bookRepository.findById(id);;
        if(book.isPresent()){
            LOGGER.info("Retrieving book by ID.");
            return book.get();
        } else {
            LOGGER.warn("Cannot find book with {} ID.", id);
            return null;
        }
    }

    @Override
    public void saveBook(@NotNull @Valid final JpaBook jpaBook) {

        if (bookRepository.findById(jpaBook.getId()).isPresent()) {
            LOGGER.info("Updating book record with {} ID.", jpaBook.getId());
        } else {
            LOGGER.info("Creating new book record.");
        }
        bookRepository.save(jpaBook);
        LOGGER.info("Book record update/create successful!");
    }

    @Override
    public long countBook() {
        return bookRepository.count();
    }

}
