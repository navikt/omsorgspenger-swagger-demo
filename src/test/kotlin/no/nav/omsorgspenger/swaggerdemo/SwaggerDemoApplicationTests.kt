package no.nav.omsorgspenger.swaggerdemo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.availability.ApplicationAvailability
import org.springframework.boot.availability.LivenessState
import org.springframework.boot.availability.ReadinessState
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SwaggerDemoApplicationTests {

    @Autowired
    private val applicationAvailability: ApplicationAvailability? = null

    @Test
    fun `Liveness & Readness checks OK`() {
        Assertions.assertTrue(applicationAvailability!!.livenessState.equals(LivenessState.CORRECT))
        Assertions.assertTrue(applicationAvailability!!.readinessState.equals(ReadinessState.ACCEPTING_TRAFFIC))
    }

}
