package com.buzzbait.boot001.biz.sample.dto

import com.buzzbait.boot001.biz.sample.entity.Article

data class AddArticleRequest(
    var title : String,
    var contents : String
){
    fun toEntity(): Article {
        return Article(title=title,contents=contents);
    }
}
