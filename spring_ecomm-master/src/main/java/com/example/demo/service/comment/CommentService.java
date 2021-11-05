package com.example.demo.service.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Item;
import com.example.demo.respositories.CommentResponsitory;
import com.example.demo.respositories.ItemResponsitory;

public interface CommentService {

	void deleteAll();

	void deleteAll(Iterable<? extends Comment> entities);

	void delete(Comment entity);

	void deleteById(Integer id);

	long count();

	List<Comment> findAllById(Iterable<Integer> ids);

	List<Comment> findAll();

	boolean existsById(Integer id);

	Optional<Comment> findById(Integer id);

	List<Comment> saveAll(List<Comment> entities);

	Comment save(Comment entity);

}
