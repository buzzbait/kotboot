package com.buzzbait.boot001.biz.dto

import com.buzzbait.boot001.biz.entity.Article

data class AddArticleRequest(
    var title : String,
    var contents : String
){
    fun toEntity(): Article {
        return Article(title=title,contents=contents);
    }
}
