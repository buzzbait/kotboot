package com.buzzbait.boot001.legacy.biz.member.dto

import com.buzzbait.boot001.legacy.biz.member.entity.MemberEntity
import com.buzzbait.boot001.legacy.biz.member.entity.MemberGradeEntity

data class AddMemberRequest(
    var id : Long,
    var email :String,
    var name :String,
    var companyName :String,
    var gradeid : Long
){
    //DTO -> Entity 변환 함수
    fun toEntity(memberGrade: MemberGradeEntity): MemberEntity {
        return MemberEntity(email=this.email,name = this.name,companyname = this.companyName,grade = memberGrade);
    }
}
