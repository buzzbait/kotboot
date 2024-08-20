package com.buzzbait.boot001.board.application.service

import com.buzzbait.boot001.board.adapter.`in`.dto.CleanCreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.CleanUpdateBoardRequest
import com.buzzbait.boot001.board.application.port.`in`.CreateBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.UpdateBoardUseCase
import com.buzzbait.boot001.board.application.port.out.BoardRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CleanBoardService(
    private  val boardRepositoryPort : BoardRepositoryPort
) : CreateBoardUseCase,UpdateBoardUseCase {

    @Transactional(readOnly = false)
    override fun createBoard(cleanCreateBoardRequest: CleanCreateBoardRequest) :Pair<Boolean,String> {
        return  boardRepositoryPort.createBoard(cleanCreateBoardRequest)
    }

    @Transactional(readOnly = false)
    override fun updateBoard(updateBoardRequest: CleanUpdateBoardRequest) :Pair<Boolean,String> {
        return boardRepositoryPort.updateBoard(updateBoardRequest)
    }
}