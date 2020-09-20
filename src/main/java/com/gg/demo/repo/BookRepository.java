package com.gg.demo.repo;


import com.gg.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 通过继承JPA提供的接口实现对数据库CRUD
 * Creat by GG
 * Date on 2020/9/19  5:02 下午
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
