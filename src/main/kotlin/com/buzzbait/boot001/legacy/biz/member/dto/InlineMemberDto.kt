package com.buzzbait.boot001.legacy.biz.member.dto

import com.buzzbait.boot001.legacy.biz.member.entity.MemberEntity

data class InlineMemberDto(
    var id : Long,
    var email :String,
    var name :String,
    var companyName :String,
    var gradeId : Long,
    var gradeName : String
){
    companion object {
        fun fromEntity(memberEntity: MemberEntity): InlineMemberDto {

            return InlineMemberDto(id = memberEntity.id,
                email = memberEntity.email,
                name = memberEntity.name,
                companyName = memberEntity.companyname,
                gradeId = memberEntity.grade.id,
                gradeName = memberEntity.grade.grade
                )
        }
    }
}
