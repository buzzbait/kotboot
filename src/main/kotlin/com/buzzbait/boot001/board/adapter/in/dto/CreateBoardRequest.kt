package com.buzzbait.boot001.board.adapter.`in`.dto

import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.BoardEntity

data class CreateBoardRequest(
    var name : String
){
    fun toEntity(): BoardEntity {
        return BoardEntity(name = this.name);
    }
}

