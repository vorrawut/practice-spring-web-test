package toptoppy.kotlin.training.springtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import toptoppy.kotlin.training.springtest.repository.ExchangeRateRepository

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class SpringtestApplicationTests(
    @Autowired private val exchangeRateRepository: ExchangeRateRepository,
    @Autowired private val mockMvc: MockMvc
) {

    companion object {

        @Container
        private val psql = PostgreSQLContainer(
            DockerImageName.parse("postgres:16.4")
        )

        @DynamicPropertySource
        @JvmStatic
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", psql::getJdbcUrl)
            registry.add("spring.datasource.username", psql::getUsername)
            registry.add("spring.datasource.password", psql::getPassword)
        }
    }

    @Test
    fun `should return balance of the given account number in THB`(){
        val accountNumber = "A123"
        mockMvc.get("/fx/$accountNumber/balance-thb"){
        }.andExpect {
            status { isOk() }
            jsonPath("$.balanceInTHB") {value(3500)}
        }

        val accountNumber2 = "B456"
        mockMvc.get("/fx/$accountNumber2/balance-thb"){
        }.andExpect {
            status { isOk() }
            jsonPath("$.balanceInTHB") {value(8000)}
        }
    }


    @Test
    fun contextLoads() {
    }

}
