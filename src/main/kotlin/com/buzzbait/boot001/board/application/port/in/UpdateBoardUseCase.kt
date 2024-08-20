package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.`in`.dto.CleanUpdateBoardRequest

interface UpdateBoardUseCase {
    fun updateBoard(updateBoardRequest: CleanUpdateBoardRequest) : Pair<Boolean,String>
}