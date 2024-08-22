package com.buzzbait.boot001.board.application.port.out


import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto

/*
    외부 DB 저장소를 사용하는 Board(게시판) Port 인터페이스

    특정 프레임워크에 종속되는 형태의 Object (ex) JpaRepository,Entity 등)를 파라미터 또는 리턴 형태로 사용하지 않는다
    파라미터와 리턴타입은 POJO 사용
 */
interface BoardRepositoryPort {
    fun createBoard( createBoardRequest: CreateBoardRequest):Pair<Boolean,String>
    fun updateBoard( updateBoardRequest: UpdateBoardRequest):Pair<Boolean,String>
    fun getBoardByUuid(boardUuid :String): GetBoardByUuidDto?
}