package com.buzzbait.boot001.board.adapter.`in`.web

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.buzzbait.boot001.board.adapter.`in`.dto.UpdateBoardRequest
import com.buzzbait.boot001.board.application.port.`in`.CreateBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.GetBoardUseCase
import com.buzzbait.boot001.board.application.port.`in`.UpdateBoardUseCase
import com.buzzbait.boot001.common.dto.CommonResponse
import com.buzzbait.boot001.common.enums.ResponseStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/board")
class BoardController(
    private val createBoardUseCase: CreateBoardUseCase,
    private val updateBoardUseCase: UpdateBoardUseCase,
    private val getBoardUseCase: GetBoardUseCase
) {

    @PutMapping("")
    fun createBoard(@RequestBody createBoardRequest: CreateBoardRequest) : ResponseEntity<CommonResponse> {
        val resultStatus = createBoardUseCase.createBoard(createBoardRequest)
        val returnResponse =  CommonResponse(ResponseStatus.booleanToResponseStatus(resultStatus.first).value,resultStatus.second,null)
        return ResponseEntity.ok(returnResponse)
    }

    @PostMapping("")
    fun updateBoard(@RequestBody updateBoardRequest: UpdateBoardRequest) : ResponseEntity<CommonResponse> {
        val resultStatus = updateBoardUseCase.updateBoard(updateBoardRequest);
        val returnResponse =  CommonResponse(ResponseStatus.booleanToResponseStatus(resultStatus.first).value,resultStatus.second,null)
        return ResponseEntity.ok(returnResponse)
    }
    @GetMapping("/{uuId}")
    fun getBoardByUuid(@PathVariable("uuId") uuId:String) : ResponseEntity<CommonResponse> {
        val getBoardByUuidDto = getBoardUseCase.getBoard(uuId)
        val returnResponse =  CommonResponse(ResponseStatus.API_OK.value,"",getBoardByUuidDto)
        return ResponseEntity.ok(returnResponse);
    }
}