package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Comments;

@Service
public interface CommentService {
	public ArrayList<Comments> getAllComments(int rest_id);
	public boolean insertComment(Comments comment);
	public boolean  updateComment(Comments comment);
	public boolean deleteComment(int id);
	public Comments getCommentById(int id);
	public int countComment();
}
