package com.buzzbait.boot001.biz.member

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController (
    private val memberService: MemberService
){
    private val logger = KotlinLogging.logger {}

    @GetMapping("/inlineMember")
    fun inlineMember() : ResponseEntity<Any?> {

        logger.info("inlineMember...");
        val memberList = memberService.getConfirmMember(1);
        logger.info { memberList.toString()}
        return ResponseEntity.ok(memberList);
    }
}