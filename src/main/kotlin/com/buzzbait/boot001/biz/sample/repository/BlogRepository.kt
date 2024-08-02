package com.buzzbait.boot001.biz.sample.repository

import com.buzzbait.boot001.biz.sample.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository : JpaRepository<Article, Long> {
}