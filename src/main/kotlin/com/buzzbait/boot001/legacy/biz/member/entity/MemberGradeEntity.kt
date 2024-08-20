package com.buzzbait.boot001.legacy.biz.member.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "membergrade", schema = "kotlin")
class MemberGradeEntity(
    @Column(name = "grade", nullable = false)
    var grade : String,

    @Column(name = "info", nullable = true)
    var info : String,

    @LastModifiedDate
    @Column(name = "updt")
    var updt: LocalDateTime = LocalDateTime.now(),

    @CreatedDate
    @Column(name = "crdt", updatable = false)
    val crdt: LocalDateTime = LocalDateTime.now()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}