package org.project2.config

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.shaded.guava.common.collect.ImmutableList
import org.project2.model.CassandraProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import java.net.InetSocketAddress

@Configuration
@EnableConfigurationProperties(CassandraProperties::class)
class CassandraBeans {
    @Bean
    fun cassandraConfig(): List<CassandraProperties> = ImmutableList.of()

    @Bean
    fun cqlSession(env: Environment): CqlSession {
        requireNotNull(env) { "env is required" }

        return CqlSession.builder()
            .addContactPoint(InetSocketAddress(env.getRequiredProperty("app-cassandra.contactPoints"), 9042))
            .withKeyspace(env.getRequiredProperty("app-cassandra.keyspaceName"))
            .withLocalDatacenter(env.getRequiredProperty("app-cassandra.localDatacenter"))
            .build()
    }
}