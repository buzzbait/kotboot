package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.`in`.dto.CleanCreateBoardRequest

interface CreateBoardUseCase {
    fun createBoard(cleanCreateBoardRequest: CleanCreateBoardRequest) : Pair<Boolean,String>
}