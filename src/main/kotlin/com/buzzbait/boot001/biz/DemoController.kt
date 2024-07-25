package com.buzzbait.boot001.biz

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo")
class DemoController {

    @GetMapping("/info")
    fun info() :  ResponseEntity<String>{
        var infoDesc  = "This is DemoController";
        return ResponseEntity.ok(infoDesc);
    }
}