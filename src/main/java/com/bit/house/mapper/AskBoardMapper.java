package com.bit.house.mapper;

import com.bit.house.domain.AskBoardVO;
import com.bit.house.domain.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.stream.events.Comment;
import java.util.List;

@Mapper
public interface AskBoardMapper {
    //게시글 목록
    public List<AskBoardVO> askBoardList() throws Exception;

    //게시글 상세
    public AskBoardVO askDetail(int askBoardNo) throws Exception;

    //게시글 작성
    public int insertAsk(AskBoardVO askBoardVO) throws Exception;

    //게시글 수정
    public int askUpdate(AskBoardVO askBoardVO) throws Exception;

    //게시글 삭제
    public int askDelete(int askBoardNo) throws Exception;

    //답글 작성
    public int askReply(AskBoardVO askBoardVO) throws Exception;

    //댓글
    public List<CommentVO> askComment(int askBoardNo) throws Exception;

    public void insertAskComment(CommentVO commentVO) throws Exception;
    //검색


}
