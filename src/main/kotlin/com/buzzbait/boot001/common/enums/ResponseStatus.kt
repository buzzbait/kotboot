package com.buzzbait.boot001.common.enums

enum class ResponseStatus(val value: String) {
    API_OK("API_OK"),
    API_FAIL("API_FAIL"); // semicolon

    fun responseStatusToBoolean() = this == API_OK
    companion object {
        fun booleanToResponseStatus(isActive: Boolean) = if (isActive) API_OK else API_FAIL
    }
}