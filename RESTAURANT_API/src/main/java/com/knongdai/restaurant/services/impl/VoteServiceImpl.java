package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Votes;
import com.knongdai.restaurant.repositories.VoteRepository;
import com.knongdai.restaurant.services.VoteService;
@Service
public class VoteServiceImpl implements VoteService{
	@Autowired
	private VoteRepository voteRepository;
	
	@Override
	public ArrayList<Votes> getAllVotes() {
		return voteRepository.getAllVotes();
	}

	@Override
	public boolean insertVote(Votes vote) {
		return voteRepository.insertVote(vote);
	}

	@Override
	public boolean updateVote(Votes vote) {
		return voteRepository.updateVote(vote);
	}

	@Override
	public boolean deleteVote(int id) {
		return voteRepository.deleteVote(id);
	}

	@Override
	public Votes getVoteById(int id) {
		return voteRepository.getVoteById(id);
	}

}
