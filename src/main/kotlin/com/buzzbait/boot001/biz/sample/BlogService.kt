package com.buzzbait.boot001.biz.sample


import com.buzzbait.boot001.biz.sample.dto.AddArticleRequest
import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.sample.repository.BlogRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BlogService (private val blogRepository : BlogRepository)
{

    @Transactional
    fun createArticle(addArticleRequest : AddArticleRequest): BuzzResponse {

        blogRepository.save(addArticleRequest.toEntity());

        return BuzzResponse("succ","추가 완료");
    }
}