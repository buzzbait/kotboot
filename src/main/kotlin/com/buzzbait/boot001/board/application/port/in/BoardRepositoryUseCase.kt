package com.buzzbait.boot001.board.application.port.`in`

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto

/*
    게시판 도메인에 관련된 메소드를 하나의 UseCase 에 구현한 예시
    DB Table 중심으로 기능이 구분되는 프로젝트에서는 더 편리함

    단일 책임의 원칙에 따르면 UseCase 에 하나의 메소드만 구현 하는게 권장 되지만
    SI 프로젝트에서 적용하기에는 너무 많은 인터페이스가 남발되는 경우가 발생

    특정 프레임워크에 종속되는 형태의 Object (ex) JpaRepository,Entity 등)를 파라미터 또는 리턴 형태로 사용하지 않는다
    파라미터와 리턴타입은 POJO 사용

    아래의 UseCase 는 BOARD 단일 테이블에 대한 CRUD 만 정의하여 단일책임(SRP) 을 테이블에 국한하여 정의
    단일 저장소 자체에 대한 UseCase 는 ***RepositoryUseCase 를 사용

    게시판의 댓글저장시 알람(메일전송)등의 기능은 ***SendMessageUseCase 등으로 분리해서 사용해야 함
 */
interface BoardRepositoryUseCase {
    fun createBoard(createBoardRequest: CreateBoardRequest) : Pair<Boolean,String>
    fun deleteBoard(): Boolean
    fun updateBoard(updateBoardRequest: UpdateBoardRequest) : Pair<Boolean,String>
    fun getBoard(boardUuid :String) : GetBoardByUuidDto?
}