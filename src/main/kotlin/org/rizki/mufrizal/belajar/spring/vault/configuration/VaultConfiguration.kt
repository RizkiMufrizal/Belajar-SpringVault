package org.rizki.mufrizal.belajar.spring.vault.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.vault.authentication.ClientAuthentication
import org.springframework.vault.authentication.TokenAuthentication
import org.springframework.vault.client.VaultEndpoint
import org.springframework.vault.config.AbstractVaultConfiguration
import java.net.URI

/**
 * Created by rizkimufrizal on 6/19/17.
 */
@Configuration
@PropertySource("classpath:application.properties")
class VaultConfiguration : AbstractVaultConfiguration() {
    override fun clientAuthentication(): ClientAuthentication = TokenAuthentication(environment.getRequiredProperty("vault.token"))

    override fun vaultEndpoint(): VaultEndpoint = VaultEndpoint.from(URI(environment.getRequiredProperty("vault.url")))
}