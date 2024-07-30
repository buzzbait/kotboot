package com.buzzbait.boot001.biz.repository

import com.buzzbait.boot001.biz.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository : JpaRepository<Article, Long> {
}