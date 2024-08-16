package com.buzzbait.boot001.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource


@Configuration
@MapperScan(    basePackages = ["com.buzzbait.boot001.mybatis.biz"],
                sqlSessionFactoryRef = "sqlSessionFactory",
                sqlSessionTemplateRef = "sqlSessionTemplate")
class MainDataSourceMybatisConfig {

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(@Qualifier("mainDataSource") dataSource: DataSource?): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)

        // mybatis 설정 파일 세팅
        sqlSessionFactoryBean.setConfigLocation(PathMatchingResourcePatternResolver().getResource("classpath:mybatis/config/mybatis-config.xml"))
        // mapper.xml 위치 패키지 주소
        sqlSessionFactoryBean.setMapperLocations(*PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/biz/**/*.xml"))

        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    @Throws(Exception::class)
    fun sqlSessionTemplate(@Qualifier("sqlSessionFactory") sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}