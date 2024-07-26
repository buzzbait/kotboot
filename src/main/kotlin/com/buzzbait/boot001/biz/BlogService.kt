package com.buzzbait.boot001.biz


import com.buzzbait.boot001.biz.domain.Article
import com.buzzbait.boot001.biz.dto.AddArticleRequest
import com.buzzbait.boot001.biz.dto.BuzzResponse
import com.buzzbait.boot001.biz.repository.BlogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service

class BlogService {
    @Autowired
    lateinit var  blogRepository : BlogRepository;

    @Transactional
    fun createArticle(addArticleRequest : AddArticleRequest):BuzzResponse{

        var article = Article(title = "test",contents = "test")
        //blogRepository.save(addArticleRequest.toEntity());
        blogRepository.save(article);
        return BuzzResponse("succ","추가 완료");
    }
}