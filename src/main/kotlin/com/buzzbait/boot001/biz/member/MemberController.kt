package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.biz.member.dto.UpdateMemberRequest
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController (
    private val memberService: MemberService
){
    private val logger = KotlinLogging.logger {}

    @GetMapping("/inlineMember")
    fun inlineMember() : ResponseEntity<Any?> {

        logger.info("inlineMember...");
        val memberList = memberService.getConfirmMember(11);
        logger.info { memberList.toString()}
        return ResponseEntity.ok(memberList);
    }

    @GetMapping("/{id}")
    fun getMember(@PathVariable("id") id:Long) : ResponseEntity<Any?> {

        logger.info("getMember...");
        val member = memberService.getMember(id);
        return ResponseEntity.ok(member.companyname);
    }

    @PostMapping("/new")
    fun updateMember(@RequestBody addMemberRequest: AddMemberRequest) : ResponseEntity<BuzzResponse>{
        val resultStatus = memberService.addMember(addMemberRequest);
        return ResponseEntity.ok(resultStatus);
    }
    @PostMapping("/update")
    fun updateMember(@RequestBody updateMemberRequest: UpdateMemberRequest) : ResponseEntity<BuzzResponse>{
        val resultStatus = memberService.updateMember(updateMemberRequest);
        return ResponseEntity.ok(resultStatus);
    }
}