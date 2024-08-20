package com.buzzbait.boot001.common.annotation

import org.springframework.stereotype.Component

/*
    Adapter클래스를 Spring Bean 으로 등록하기 위한 Annotation
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Component
annotation class PersistenceAdapter(
    val message: String = "PersistenceAdapter"
){

}
