package com.buzzbait.boot001.biz

import com.buzzbait.boot001.biz.dto.AddArticleRequest
import com.buzzbait.boot001.biz.dto.BuzzResponse
import com.buzzbait.boot001.biz.repository.BlogRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/demo")
class DemoController(
    private val  blogService: BlogService,
    private val memberService: MemberService
)
{
    private val logger = KotlinLogging.logger {}
    @GetMapping("/info")
    fun info() :  ResponseEntity<String>{
        var infoDesc  = "This is DemoController...";
        return ResponseEntity.ok(infoDesc);
    }

    @PostMapping("/article")
    fun newArticle(@RequestBody addArticleRequest: AddArticleRequest) :  ResponseEntity<BuzzResponse>{

        logger.info("new article call...");
        var buzzResponse = blogService.createArticle(addArticleRequest);
        return ResponseEntity.ok(buzzResponse);
    }

    @GetMapping("/inlineMember")
    fun inlineMember() :  ResponseEntity<Any?>{

        logger.info("inlineMember...");
        val memberList = memberService.getConfirmMember(1);
        logger.info { memberList.toString()}
        return ResponseEntity.ok(memberList);
    }
}