package com.buzzbait.boot001.biz

import com.buzzbait.boot001.biz.dto.AddArticleRequest
import com.buzzbait.boot001.biz.dto.BuzzResponse
import com.buzzbait.boot001.biz.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/demo")
class DemoController {

    @Autowired
    lateinit var  blogService: BlogService;

    @GetMapping("/info")
    fun info() :  ResponseEntity<String>{
        var infoDesc  = "This is DemoController...";
        return ResponseEntity.ok(infoDesc);
    }

    @PostMapping("/article")
    fun newArticle(@RequestBody addArticleRequest: AddArticleRequest) :  ResponseEntity<BuzzResponse>{
        //var addArticleRequest  = AddArticleRequest(title="테스트", contents = "테스트임");
        var buzzResponse = blogService.createArticle(addArticleRequest);
        return ResponseEntity.ok(buzzResponse);
    }
}