package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.dto.Ranking.RankDto;
import org.zerock.domain.dto.Ranking.RankListDto;
import org.zerock.domain.entity.Ranking;
import org.zerock.domain.entity.User;
import org.zerock.repository.RankingRepository;
import org.zerock.repository.UserRepository;

@Service
public class RankingService {
	
	private RankingRepository rankingRepository;
	private UserRepository userRepository;

	public RankingService(RankingRepository rankingRepository, UserRepository userRepository) {
		this.rankingRepository=rankingRepository;
		this.userRepository=userRepository;
	}
	
	//점수 기록
	public void recordScore(RankDto rankDto) {
		
		Ranking Rank=new Ranking();
		User user=userRepository.findById(rankDto.getId());
		Rank.setUser(user);
		Rank.setSong(rankDto.getSong());
		Rank.setScore(rankDto.getScore());
		
		rankingRepository.save(Rank);
		
	}
	
	//해당곡 랭킹 보여주기
	public List<RankListDto> getRank(String song){
		
		List<Ranking> RankEntityList = rankingRepository.findBySongOrderByScoreDesc(song);
		List<RankListDto> RankList=new ArrayList<>();
		
		for(int i=0; i<RankEntityList.size(); i++) {
			RankListDto rank=new RankListDto();
			rank.setId(RankEntityList.get(i).getUser().getId());
			rank.setScore(RankEntityList.get(i).getScore());
			RankList.add(rank);
		}
		
		return RankList;
	}
	
}
