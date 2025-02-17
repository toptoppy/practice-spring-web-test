package toptoppy.kotlin.training.springtest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "fx_account")
data class FxAccountEntity(
    @Id
    val accountId: String,
    val balance: Double,
    val currency: String
)
