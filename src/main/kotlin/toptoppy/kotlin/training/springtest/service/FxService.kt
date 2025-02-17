package toptoppy.kotlin.training.springtest.service

import org.springframework.stereotype.Service
import toptoppy.kotlin.training.springtest.repository.ExchangeRateRepository
import toptoppy.kotlin.training.springtest.repository.FxAccountRepository

@Service
class FxService(
    val fxAccountRepository: FxAccountRepository,
    val exchangeRateRepository: ExchangeRateRepository
) {
    fun getBalanceInTHB(accountId: String): Double {
        val account = fxAccountRepository.findByAccountId(accountId) ?: throw Exception("Account not found")
        val exchangeRate = exchangeRateRepository.findByCurrency("USD") ?: throw Exception("Exchange rate not found")
        return account.balance * exchangeRate.sellRate
    }
}
