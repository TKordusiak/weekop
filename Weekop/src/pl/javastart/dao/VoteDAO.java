package pl.javastart.dao;

import pl.javastart.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long>{
	public Vote getVoteByUserIdDiscovery(long UserId, long Discovery);
}
