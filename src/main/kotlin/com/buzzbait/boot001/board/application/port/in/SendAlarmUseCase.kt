package com.buzzbait.boot001.board.application.port.`in`

/*
    게시판 글에 댓글 등록시 글 작성자에 알람 보내기
 */
interface SendAlarmUseCase {
    fun sendToPostOwner(ownerId : String) : Pair<Boolean,String>
}