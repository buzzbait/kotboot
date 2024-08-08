package com.buzzbait.boot001.biz.member.dto

import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity

data class MemberGradeDto(
    var id : Long?,
    var grade :String?,
    var info : String?
){

    companion object {
        fun fromEntity(memberGradeEntity: MemberGradeEntity?): MemberGradeDto {

            return MemberGradeDto(id = memberGradeEntity?.id,
                grade = memberGradeEntity?.grade,
                info = memberGradeEntity?.info
            )
        }
    }
}
