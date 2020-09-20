package com.gg.demo.repo;


import com.gg.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creat by GG
 * Date on 2020/9/19  5:02 下午
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
