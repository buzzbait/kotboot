package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto

interface GetBoardUseCase {
    fun getBoard(boardUuid :String) :GetBoardByUuidDto?
}