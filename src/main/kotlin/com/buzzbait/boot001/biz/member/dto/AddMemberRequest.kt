package com.buzzbait.boot001.biz.member.dto

import com.buzzbait.boot001.biz.member.entity.Member
import com.buzzbait.boot001.biz.member.entity.MemberGrade
import com.buzzbait.boot001.biz.sample.entity.Article

data class AddMemberRequest(
    var id : Long,
    var email :String,
    var name :String,
    var companyName :String,
    var gradeid : Long
){
    //DTO -> Entity 변환 함수
    fun toEntity(memberGrade: MemberGrade): Member {
        return Member(email=this.email,name = this.name,companyname = this.companyName,grade = memberGrade);
    }
}
