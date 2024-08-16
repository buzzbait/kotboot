package com.buzzbait.boot001.config

import jakarta.persistence.EntityManagerFactory
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

/*
    멀티 DataSource 설정시에는 @Configuration 클래스를 구현하여 Primary 와 그외 DataSource 를 별도로 지정 해야 함.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "mainEntityManagerFactory",
    transactionManagerRef = "mainTransactionManager",
    basePackages = ["com.buzzbait.boot001.biz"]
)
class MainDataSourceJpaConfig() {

    private val logger = KotlinLogging.logger {}

    init {
        logger.info("MainDataSourceConfig Created...")
    }

    @Primary
    @Bean
    @ConfigurationProperties("main-db.datasource")
    fun mainDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Primary
    @Bean(name = ["mainDataSource"])
    @ConfigurationProperties("main-db.datasource.configuration")
    fun mainDataSource(): DataSource {
        return mainDataSourceProperties().initializeDataSourceBuilder().build()
    }


    @Primary
    @Bean(name = ["mainEntityManagerFactory"])
    fun mainEntityManagerFactory(
        builder: EntityManagerFactoryBuilder
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(mainDataSource())
            .packages("com.buzzbait.boot001.biz")
            .persistenceUnit("main")
            .build()
    }

    @Primary
    @Bean(name = ["mainTransactionManager"])
    fun transactionManager(
        @Qualifier("mainEntityManagerFactory") mainEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(mainEntityManagerFactory)
    }
}