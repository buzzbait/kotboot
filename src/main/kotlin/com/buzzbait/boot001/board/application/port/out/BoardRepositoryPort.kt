package com.buzzbait.boot001.board.application.port.out


import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto

/*
    외부 DB 저장소를 사용하는 Board(게시판) Port 인터페이스
    함수파라미터 와 리턴타입에 Jpa Entity 를 직접 사용하지 않는다
 */
interface BoardRepositoryPort {
    fun createBoard( createBoardRequest: CreateBoardRequest):Pair<Boolean,String>
    fun updateBoard( updateBoardRequest: UpdateBoardRequest):Pair<Boolean,String>
    fun getBoardByUuid(boardUuid :String): GetBoardByUuidDto?
}