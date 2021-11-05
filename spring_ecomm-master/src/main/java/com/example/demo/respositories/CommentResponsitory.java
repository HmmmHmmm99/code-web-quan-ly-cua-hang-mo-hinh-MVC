package com.example.demo.respositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Comment;

public interface CommentResponsitory extends CrudRepository<Comment,Integer> {

}
