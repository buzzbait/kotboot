package com.buzzbait.boot001.infrastructure.dbms.master.mybatis.mapper

import org.apache.ibatis.annotations.Mapper

@Mapper
interface CleanBoardMapper {
    fun selectBoardCnt() : Int
}