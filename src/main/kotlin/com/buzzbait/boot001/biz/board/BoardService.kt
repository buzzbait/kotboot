package com.buzzbait.boot001.biz.board

import com.buzzbait.boot001.biz.board.dto.NewBoardDto
import com.buzzbait.boot001.biz.board.dto.UpdateBoardDto
import com.buzzbait.boot001.biz.board.repository.BoardRepository
import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    private val logger = KotlinLogging.logger {}

    @Transactional(readOnly = false)
    fun addBoard(
        newBoardDto: NewBoardDto
    ): BuzzResponse {

        val newBoardEntity = newBoardDto.toEntity();
        boardRepository.save(newBoardEntity);

        return BuzzResponse("succ","추가 완료");
    }

    @Transactional(readOnly = false)
    fun updateBoard(
        updateBoardDto: UpdateBoardDto
    ): BuzzResponse {

        val findUuid = UUID.fromString(updateBoardDto.uuid);
        val boardEntity = boardRepository.findByUuid(findUuid);

        boardEntity?: return BuzzResponse("fail","대상건 없음")

        boardEntity.name = updateBoardDto.name;
        return BuzzResponse("succ","추가 완료");
    }
}