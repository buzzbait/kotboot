package com.buzzbait.boot001.board.application.service

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto
import com.buzzbait.boot001.board.application.port.`in`.CreateBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.GetBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.UpdateBoardUseCase
import com.buzzbait.boot001.board.application.port.out.BoardRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private  val boardRepositoryPort : BoardRepositoryPort
) : CreateBoardUseCase,UpdateBoardUseCase, GetBoardUseCase {

    @Transactional(readOnly = false)
    override fun createBoard(createBoardRequest: CreateBoardRequest) :Pair<Boolean,String> {
        return  boardRepositoryPort.createBoard(createBoardRequest)
    }

    @Transactional(readOnly = false)
    override fun updateBoard(updateBoardRequest: UpdateBoardRequest) :Pair<Boolean,String> {
        return boardRepositoryPort.updateBoard(updateBoardRequest)
    }

    override fun getBoard(boardUuid: String): GetBoardByUuidDto? {
        return boardRepositoryPort.getBoardByUuid(boardUuid)
    }

}