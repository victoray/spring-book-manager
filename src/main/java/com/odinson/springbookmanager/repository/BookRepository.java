package com.odinson.springbookmanager.repository;

import com.odinson.springbookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
