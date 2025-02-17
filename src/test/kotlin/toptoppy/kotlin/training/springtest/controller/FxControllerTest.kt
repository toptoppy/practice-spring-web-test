package toptoppy.kotlin.training.springtest.controller

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import toptoppy.kotlin.training.springtest.service.FxService

@WebMvcTest(controllers = [FxController::class])
class FxControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @MockitoBean
    private lateinit var fxService: FxService

    @Test
    fun `should return balance in THB`() {
        `when`(fxService.getBalanceInTHB("A123")).thenReturn(3500.0)

        mockMvc.perform(get("/fx/A123/balance-thb"))
            .andExpect(status().isOk)
            .andExpect(content().string("3500.0"))
    }
}
