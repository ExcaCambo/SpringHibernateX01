package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Votes;
@Service
public interface VoteService {
	public ArrayList<Votes> getAllVotes();
	public boolean insertVote(Votes vote);
	public boolean  updateVote(Votes vote);
	public boolean deleteVote(int id);
	public Votes getVoteById(int id);
}
