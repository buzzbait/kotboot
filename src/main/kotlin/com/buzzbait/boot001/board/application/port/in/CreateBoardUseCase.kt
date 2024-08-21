package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest

interface CreateBoardUseCase {
    fun createBoard(createBoardRequest: CreateBoardRequest) : Pair<Boolean,String>
}