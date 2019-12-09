package org.zerock.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zerock.domain.entity.Ranking;

public interface RankingRepository extends PagingAndSortingRepository<Ranking,Long>{

	//노래로 데이터 조회 후 점수로 내림차순 정렬
	List<Ranking> findBySongOrderByScoreDesc(String song);

}
