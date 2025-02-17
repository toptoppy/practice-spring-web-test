package toptoppy.kotlin.training.springtest.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import toptoppy.kotlin.training.springtest.entity.ExchangeRateEntity
import toptoppy.kotlin.training.springtest.entity.FxAccountEntity
import toptoppy.kotlin.training.springtest.repository.ExchangeRateRepository
import toptoppy.kotlin.training.springtest.repository.FxAccountRepository
import kotlin.test.assertEquals

class FxServiceWithMockkTest {

    private val fxAccountRepository: FxAccountRepository = mockk()
    private val exchangeRateRepository: ExchangeRateRepository = mockk()

    private lateinit var fxAccountService: FxService

    @BeforeEach
    fun setUp() {
        fxAccountService = FxService(fxAccountRepository, exchangeRateRepository)
    }

    @Test
    fun `should covert balance in THB correctly`() {
        val account = FxAccountEntity("A123", 100.0, "USD")
        val exchangeRate = ExchangeRateEntity("USD", 35.0, 35.5)

        every { fxAccountRepository.findByAccountId("A123") } returns account
        every { exchangeRateRepository.findByCurrency("USD") } returns exchangeRate

        // when
        val balanceInTHB = fxAccountService.getBalanceInTHB("A123")

        // then
        assertEquals(3500.0, balanceInTHB)

        verify(exactly = 1) { fxAccountRepository.findByAccountId("A123") }
        verify(exactly = 1) { exchangeRateRepository.findByCurrency("USD") }
    }
}
