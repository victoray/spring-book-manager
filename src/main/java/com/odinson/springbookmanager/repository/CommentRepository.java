package com.odinson.springbookmanager.repository;

import com.odinson.springbookmanager.model.Book;
import com.odinson.springbookmanager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Book findByBook(Book book);
}
