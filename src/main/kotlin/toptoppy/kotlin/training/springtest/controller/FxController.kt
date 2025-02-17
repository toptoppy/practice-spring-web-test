package toptoppy.kotlin.training.springtest.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import toptoppy.kotlin.training.springtest.service.FxService

@RestController
@RequestMapping("/fx")
class FxController(
    val fxService: FxService
) {

    @GetMapping("/{accountId}/balance-thb")
    fun getBalanceInTHB(@PathVariable accountId: String): ResponseEntity<Double?> {
        return ResponseEntity.ok(fxService.getBalanceInTHB(accountId))
    }
}
