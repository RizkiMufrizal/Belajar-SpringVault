package org.rizki.mufrizal.belajar.spring.vault

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.Environment
import org.springframework.vault.annotation.VaultPropertySource

@SpringBootApplication
@VaultPropertySource(value = "secret/belajar")
class BelajarSpringVaultApplication @Autowired constructor(val environment: Environment) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(BelajarSpringVaultApplication::class.java)

    override fun run(vararg args: String?) {
        logger.info("hasil secret dari url : ${environment.getRequiredProperty("spring.datasource.url")}")
        logger.info("hasil secret dari username : ${environment.getRequiredProperty("spring.datasource.username")}")
        logger.info("hasil secret dari password : ${environment.getRequiredProperty("spring.datasource.password")}")
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BelajarSpringVaultApplication::class.java, *args)
}