package com.buzzbait.boot001.common.dto

data class CommonResponse(
    var status :String,
    var message : String,
    var resultDto : Any?
)
