package com.buzzbait.boot001.board.application.service

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto
import com.buzzbait.boot001.board.application.port.`in`.BoardRepositoryUseCase
import com.buzzbait.boot001.board.application.port.out.BoardRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardRepositoryService(
    private  val boardRepositoryPort : BoardRepositoryPort
) : BoardRepositoryUseCase {

    @Transactional(readOnly = false)
    override fun createBoard(createBoardRequest: CreateBoardRequest) :Pair<Boolean,String> {
        return  boardRepositoryPort.createBoard(createBoardRequest)
    }


    @Transactional(readOnly = false)
    override fun updateBoard(updateBoardRequest: UpdateBoardRequest) :Pair<Boolean,String> {
        return boardRepositoryPort.updateBoard(updateBoardRequest)
    }

    override fun deleteBoard(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBoard(boardUuid: String): GetBoardByUuidDto? {
        return boardRepositoryPort.getBoardByUuid(boardUuid)
    }

}