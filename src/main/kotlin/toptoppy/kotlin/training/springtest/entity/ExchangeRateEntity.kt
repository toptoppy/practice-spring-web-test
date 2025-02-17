package toptoppy.kotlin.training.springtest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "exchange_rate")
data class ExchangeRateEntity(
    @Id
    val currency: String,
    val sellRate: Double,
    val buyRate: Double
)
