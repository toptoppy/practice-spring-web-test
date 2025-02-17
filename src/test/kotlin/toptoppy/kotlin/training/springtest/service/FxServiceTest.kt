package toptoppy.kotlin.training.springtest.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import toptoppy.kotlin.training.springtest.entity.ExchangeRateEntity
import toptoppy.kotlin.training.springtest.entity.FxAccountEntity
import toptoppy.kotlin.training.springtest.repository.ExchangeRateRepository
import toptoppy.kotlin.training.springtest.repository.FxAccountRepository
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class FxServiceTest {

    @Mock
    private lateinit var fxAccountRepository: FxAccountRepository

    private val exchangeRateRepository: ExchangeRateRepository = mock(ExchangeRateRepository::class.java)

    private lateinit var fxAccountService: FxService

    @BeforeEach
    fun setUp() {
        fxAccountService = FxService(fxAccountRepository, exchangeRateRepository)
    }

    @Test
    fun `should covert balance in THB correctly`() {
        val account = FxAccountEntity("A123", 100.0, "USD")
        val exchangeRate = ExchangeRateEntity("USD", 35.0, 35.5)

        `when`(fxAccountRepository.findByAccountId("A123")).thenReturn(account)
        `when`(exchangeRateRepository.findByCurrency("USD")).thenReturn(exchangeRate)

        // when
        val balanceInTHB = fxAccountService.getBalanceInTHB("A123")

        // then
        assertEquals(3500.0, balanceInTHB)
    }
}
