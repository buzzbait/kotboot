package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest

interface UpdateBoardUseCase {
    fun updateBoard(updateBoardRequest: UpdateBoardRequest) : Pair<Boolean,String>
}