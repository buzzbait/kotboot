package com.buzzbait.boot001.board.adapter.`in`.web

import com.buzzbait.boot001.board.adapter.`in`.dto.CleanCreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.CleanUpdateBoardRequest
import com.buzzbait.boot001.board.application.port.`in`.CreateBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.UpdateBoardUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cleanboard")
class CleanBoardController(
    private val createBoardUseCase: CreateBoardUseCase,
    private val updateBoardUseCase: UpdateBoardUseCase
) {

    @PutMapping("")
    fun createBoard(@RequestBody cleanCreateBoardRequest: CleanCreateBoardRequest) : ResponseEntity<String> {
        val resultStatus = createBoardUseCase.createBoard(cleanCreateBoardRequest)
        return ResponseEntity.ok("OK")
    }

    @PostMapping("")
    fun updateBoard(@RequestBody cleanUpdateBoardRequest: CleanUpdateBoardRequest) : ResponseEntity<String> {
        val resultStatus = updateBoardUseCase.updateBoard(cleanUpdateBoardRequest);
        return ResponseEntity.ok("OK")
    }
}