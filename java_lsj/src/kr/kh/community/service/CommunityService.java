package kr.kh.community.service;

import java.util.List;

import kr.kh.community.controller.board;
import kr.kh.community.model.Board;

public interface CommunityService {

	List<board> getBoardListByDate(String date);

	boolean insertBoard(Board board);

}
