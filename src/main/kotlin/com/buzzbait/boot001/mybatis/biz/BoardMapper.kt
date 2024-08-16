package com.buzzbait.boot001.mybatis.biz

import org.apache.ibatis.annotations.Mapper

@Mapper
interface BoardMapper {
    fun selectBoardCnt() : Int
}