package com.example.demo.service.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Item;
import com.example.demo.respositories.CommentResponsitory;
import com.example.demo.respositories.ItemResponsitory;
@Service
public class CommentServiceImpl implements CommentService{


	@Autowired
	CommentResponsitory commentResponsitory;

	
	@Override
	public Comment save(Comment entity) {
		return commentResponsitory.save(entity);
	}

	@Override
	public List<Comment> saveAll(List<Comment> entities) {
		return (List<Comment>)commentResponsitory.saveAll(entities);
	}

	@Override
	public Optional<Comment> findById(Integer id) {
		return commentResponsitory.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return commentResponsitory.existsById(id);
	}

	@Override
	public List<Comment> findAll() {
		return (List<Comment>)commentResponsitory.findAll();
	}

	@Override
	public List<Comment> findAllById(Iterable<Integer> ids) {
		return (List<Comment>)commentResponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return commentResponsitory.count();
	}

	@Override
	public void deleteById(Integer id) {
		commentResponsitory.deleteById(id);
	}

	@Override
	public void delete(Comment entity) {
		commentResponsitory.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Comment> entities) {
		commentResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		commentResponsitory.deleteAll();
	}
	
	
	
}
