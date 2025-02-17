package toptoppy.kotlin.training.springtest.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import toptoppy.kotlin.training.springtest.service.FxService

@WebMvcTest(controllers = [FxController::class])
class FxControllerWithSpringMockkTest(
    @Autowired
    val mockMvc: MockMvc
) {

    @MockkBean
    private lateinit var fxService: FxService

    @Test
    fun `should return balance in THB`() {
        every { fxService.getBalanceInTHB("A123") } returns 3500.0

        mockMvc.get("/fx/A123/balance-thb")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                content { json("3500.0") }
            }

        verify { fxService.getBalanceInTHB("A123") }
    }
}
