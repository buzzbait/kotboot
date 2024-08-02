package com.buzzbait.boot001.biz.entity

import jakarta.persistence.*

@Entity
@Table(name = "member", schema = "kotlin")
class Member (
    @Column(name = "email", nullable = true)
    var email : String,

    @Column(name = "name", nullable = true)
    var name : String,

    @Column(name = "companyname", nullable = true)
    var companyname : String,

    @Column(name = "grade", nullable = true)
    var grade : String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}