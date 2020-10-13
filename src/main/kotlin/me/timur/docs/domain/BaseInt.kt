package me.timur.docs.domain

import com.fasterxml.jackson.databind.JsonNode
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class, defaultForType = JsonNode::class)
)
@MappedSuperclass
open class BaseInt{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Int = 0

    @Column(name = "date_created")
    @CreationTimestamp
    var dateCreated: Timestamp? = null

    @Column(name = "date_updated")
    @UpdateTimestamp
    var dateUpdated: Timestamp? = null
}