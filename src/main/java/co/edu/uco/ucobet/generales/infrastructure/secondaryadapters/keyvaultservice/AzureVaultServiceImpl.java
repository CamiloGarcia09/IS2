package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.keyvaultservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AzureVaultServiceImpl implements VaultService {

    private final SecretClient secretClient;

    public AzureVaultServiceImpl (@Value("${azure.keyvault.url}") String urlVault){
        this.secretClient = new SecretClientBuilder().vaultUrl(urlVault)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    @Override
    public String getSecretValue(String secretName) {
        return secretClient.getSecret(secretName).getValue();
    }
}
