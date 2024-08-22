package com.buzzbait.boot001.board.adapter.out.persistence

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.adapter.out.dto.GetBoardByUuidDto
import com.buzzbait.boot001.board.application.port.out.BoardRepositoryPort
import com.buzzbait.boot001.common.annotation.PersistenceAdapter
import com.buzzbait.boot001.infrastructure.dbms.master.jpa.repository.BoardJpaRepository
import java.util.*

/*
    application.port.out 의 BoardRepository 구현체

    특정 조회 메소드가 JPA 로 구현이 불가능한 경우 Mybatis 로 SQL 작성후 Mapper 를 DI 받아서 사용한다
    Application(Service) 입장에서는 Port Out 의 인터페이스 메소드만 호출하기 때문에 해당 메소드가
    JPA 로 구현되었는지 MyBatis 로 구현되어 있는지 상관하지 않으며 소스 수정도 발생하지 않는다
 */
@PersistenceAdapter
class BoardPersistenceAdapter (
    private val boardRepository: BoardJpaRepository
): BoardRepositoryPort {

    override fun createBoard(createBoardRequest: CreateBoardRequest) : Pair<Boolean,String>{
        val boardEntity = createBoardRequest.toEntity()
        boardRepository.save(boardEntity)
        return  Pair(true,"게시판 추가");
    }

    override fun updateBoard(updateBoardRequest: UpdateBoardRequest):Pair<Boolean,String>{
        val findUuid = UUID.fromString(updateBoardRequest.uuid);
        val boardEntity = boardRepository.findByUuid(findUuid);

        boardEntity?: return Pair(false,"대상게시판이 없음");
        boardEntity.name = updateBoardRequest.name;

        return Pair(true,"게시판 수정");

    }

    override fun getBoardByUuid(boardUuid: String): GetBoardByUuidDto? {
        val uuid  =  UUID.fromString(boardUuid)
        val returnDto = boardRepository.findByUuid(uuid)?.let {
            GetBoardByUuidDto(it.name,it.useYN,it.createDt.toString())
        }
        return returnDto;
    }
}