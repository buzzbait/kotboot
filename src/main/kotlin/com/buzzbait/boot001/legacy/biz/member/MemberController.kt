package com.buzzbait.boot001.legacy.biz.member

import com.buzzbait.boot001.legacy.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.legacy.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.legacy.biz.member.dto.UpdateMemberRequest
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController (
    private val memberService: com.buzzbait.boot001.legacy.biz.member.MemberService
){
    private val logger = KotlinLogging.logger {}

    @GetMapping("/inlineMember/{id}")
    fun inlineMember(@PathVariable("id") id:Long) : ResponseEntity<Any?> {

        logger.info("inlineMember...");
        val memberList = memberService.getInlineMember(id);

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
    fun updateMember(@RequestBody updateMemberRequest: com.buzzbait.boot001.legacy.biz.member.dto.UpdateMemberRequest) : ResponseEntity<BuzzResponse>{
        val resultStatus = memberService.updateMember(updateMemberRequest);
        return ResponseEntity.ok(resultStatus);
    }
}