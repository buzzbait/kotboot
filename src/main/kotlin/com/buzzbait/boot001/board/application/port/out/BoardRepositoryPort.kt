package com.buzzbait.boot001.board.application.port.out


import com.buzzbait.boot001.board.adapter.`in`.dto.CleanCreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.CleanUpdateBoardRequest

/*
    외부 DB 저장소를 사용하는 Board(게시판) Port 인터페이스
 */
interface BoardRepositoryPort {
    fun createBoard( createBoardRequest: CleanCreateBoardRequest):Pair<Boolean,String>
    fun updateBoard( updateBoardRequest: CleanUpdateBoardRequest):Pair<Boolean,String>
}