package org.project2.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app-cassandra")
data class CassandraProperties(
    val contactPoints: String,
    val keyspaceName: String,
    val localDatacenter: String,
    val schemaAction: String
) {
    init {
        requireNotNull(contactPoints) { "datacenter cannot be blank" }
        requireNotNull(keyspaceName) { "password cannot be blank" }
        requireNotNull(localDatacenter) { "servers cannot be blank" }
        requireNotNull(schemaAction) { "user cannot be blank" }
    }
}