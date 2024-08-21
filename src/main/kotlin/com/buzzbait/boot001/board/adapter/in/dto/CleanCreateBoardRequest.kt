package com.buzzbait.boot001.board.adapter.`in`.dto

import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.CleanBoardEntity

data class CleanCreateBoardRequest(
    var name : String
){
    fun toEntity(): CleanBoardEntity {
        return CleanBoardEntity(name = this.name);
    }
}

