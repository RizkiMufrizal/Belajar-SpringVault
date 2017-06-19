package org.rizki.mufrizal.belajar.spring.vault

import com.winterbe.expekt.should
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.vault.annotation.VaultPropertySource

@RunWith(SpringRunner::class)
@SpringBootTest
@VaultPropertySource(value = "secret/belajar")
class BelajarSpringVaultApplicationTests {

    @Autowired
    lateinit var environment: Environment

    private val logger = LoggerFactory.getLogger(BelajarSpringVaultApplicationTests::class.java)

    @Test
    fun testUrl() {
        logger.info("begin test url")
        environment.getRequiredProperty("spring.datasource.url").should.equal("jdbc:mariadb://127.0.0.1:3306/microservice_book?autoReconnect=true")
        environment.getRequiredProperty("spring.datasource.url").should.not.`null`
        environment.getRequiredProperty("spring.datasource.url").should.not.`empty`
        logger.info("end test url")
    }

    @Test
    fun testUsername() {
        logger.info("begin test username")
        environment.getRequiredProperty("spring.datasource.username").should.equal("root")
        environment.getRequiredProperty("spring.datasource.username").should.not.`null`
        environment.getRequiredProperty("spring.datasource.username").should.not.`empty`
        logger.info("end test username")
    }

    @Test
    fun testPassword() {
        logger.info("begin test password")
        environment.getRequiredProperty("spring.datasource.password").should.equal("admin")
        environment.getRequiredProperty("spring.datasource.password").should.not.`null`
        environment.getRequiredProperty("spring.datasource.password").should.not.`empty`
        logger.info("end test password")
    }
}