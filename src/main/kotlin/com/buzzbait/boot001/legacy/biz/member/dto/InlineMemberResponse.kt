package com.buzzbait.boot001.legacy.biz.member.dto

data class InlineMemberResponse(
    var id : Long,
    var email :String,
    var name :String,
    var companyName :String,
    var gradeId : Long,
    var gradeName : String
)
