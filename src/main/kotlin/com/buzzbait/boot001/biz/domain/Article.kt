package com.buzzbait.boot001.biz.domain


import jakarta.persistence.*
import lombok.AccessLevel
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Entity
@Getter
@Table(name = "article", schema = "kotlin")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
class Article(title:String,contents:String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id : Long = 0;

    @Column(name = "title", nullable = false)
    var title : String = title;

    @Column(name = "contents", nullable = false)
    var contents : String = contents;

}