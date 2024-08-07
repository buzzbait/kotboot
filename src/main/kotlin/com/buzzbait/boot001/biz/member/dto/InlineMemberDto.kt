package com.buzzbait.boot001.biz.member.dto

import com.buzzbait.boot001.biz.member.entity.Member

data class InlineMemberDto(
    var id : Long,
    var email :String,
    var name :String,
    var companyName :String,
    var gradeId : Long,
    var gradeName : String
){
    companion object {
        fun fromEntity(memberEntity: Member): InlineMemberDto {

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
