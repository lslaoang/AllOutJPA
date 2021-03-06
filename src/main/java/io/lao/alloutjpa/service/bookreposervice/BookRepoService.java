package io.lao.alloutjpa.service.bookreposervice;

import io.lao.alloutjpa.dao.JpaBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookRepoService {

    List<JpaBook> getAllBooks();

    JpaBook findBookById(String  id);

    void saveBook(JpaBook jpaBook);

    void updateBook(JpaBook jpaBook);

    long countBook();

}
