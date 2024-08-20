package com.buzzbait.boot001.board.adapter.out.persistence

import com.buzzbait.boot001.board.adapter.`in`.dto.CleanCreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.CleanUpdateBoardRequest
import com.buzzbait.boot001.board.application.port.out.BoardRepositoryPort
import com.buzzbait.boot001.common.annotation.PersistenceAdapter
import java.util.*

/*
    application.port.out 의 BoardRepository 구현체
 */
@PersistenceAdapter
class CleanBoardPersistenceAdapter (
    private val boardRepository: CleanBoardRepository
): BoardRepositoryPort {

    override fun createBoard(createBoardRequest: CleanCreateBoardRequest) : Pair<Boolean,String>{
        val boardEntity = createBoardRequest.toEntity()
        boardRepository.save(boardEntity)
        return  Pair(true,"게시판 추가");
    }

    override fun updateBoard(updateBoardRequest: CleanUpdateBoardRequest):Pair<Boolean,String>{
        val findUuid = UUID.fromString(updateBoardRequest.uuid);
        val boardEntity = boardRepository.findByUuid(findUuid);

        boardEntity?: return Pair(false,"대상게시판이 없음");
        boardEntity.name = updateBoardRequest.name;

        return Pair(true,"게시판 수정");

    }
}