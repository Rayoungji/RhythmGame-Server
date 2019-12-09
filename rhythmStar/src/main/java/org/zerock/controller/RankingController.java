package org.zerock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.dto.Ranking.RankDto;
import org.zerock.service.RankingService;

@RestController
public class RankingController {
	
	private RankingService rankingService;
	
	public RankingController(RankingService rankingService) {
		this.rankingService=rankingService;
	}
	
	//점수기록
	@RequestMapping(value="/Ranking/record",method=RequestMethod.POST)
	public void recordScore(@RequestBody RankDto rankDto) {
		rankingService.recordScore(rankDto);
	}
	
	//해당곡 랭킹 조회(점수 오름차순)
	@RequestMapping(value="/Ranking/{song}",method=RequestMethod.GET)
	public List<RankDto> getRank(@PathVariable String song) {
		return rankingService.getRank(song);
	}

}
