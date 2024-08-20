package com.buzzbait.boot001.legacy.biz.board.dto

import com.buzzbait.boot001.legacy.biz.board.entity.BoardEntity

data class NewBoardDto(
    var name : String
){
    fun toEntity(): BoardEntity{
        return BoardEntity(name = this.name);
    }
}
