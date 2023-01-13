package org.project2.model

import org.springframework.data.cassandra.core.mapping.CassandraType
import org.springframework.data.cassandra.core.mapping.PrimaryKey

data class User(
    @PrimaryKey
    @CassandraType(type = CassandraType.Name.VARCHAR)
    val username: String,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    val firstName: String,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    val lastName: String,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    val email: String,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    var password: String,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    var role: String? = null,

    @CassandraType(type = CassandraType.Name.VARCHAR)
    var creditCard: String? = null
)