package com.buzzbait.boot001.biz.board


import com.buzzbait.boot001.biz.board.dto.NewBoardDto
import com.buzzbait.boot001.biz.board.dto.UpdateBoardDto
import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController (
    private val boardService: BoardService
){

    //신규보드 저장
    @PutMapping("")
    fun addBoard(@RequestBody newBoardDto: NewBoardDto) : ResponseEntity<BuzzResponse> {
        val resultStatus = boardService.addBoard(newBoardDto);
        return ResponseEntity.ok(resultStatus);
    }

    @PostMapping("")
    fun updateBoard(@RequestBody updateBoardDto: UpdateBoardDto) : ResponseEntity<BuzzResponse> {
        val resultStatus = boardService.updateBoard(updateBoardDto);
        return ResponseEntity.ok(resultStatus);
    }
}