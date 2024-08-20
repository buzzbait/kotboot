package com.buzzbait.boot001.legacy.mybatis.biz

import org.apache.ibatis.annotations.Mapper

@Mapper
interface BoardMapper {
    fun selectBoardCnt() : Int
}