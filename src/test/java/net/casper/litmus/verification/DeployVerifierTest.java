package net.casper.litmus.verification;

import com.casper.sdk.model.deploy.Deploy;
import net.casper.litmus.DeployCache;
import net.casper.litmus.exception.DeployVerificationException;
import org.junit.jupiter.api.Test;

public class DeployVerifierTest {
    private final DeployVerifier verifier = new DeployVerifier();
    private final DeployCache deployCache = new DeployCache();
    @Test
    void verifyDeploySuccess() {
        for (Deploy deploy : deployCache.getDeploysSuccess()){
            verifier.verifyDeploy(deploy);
        }
    }
    @Test
    void verifyDeployFail() {

        for (Deploy deploy : deployCache.getDeploysFail()) {
            try {
                verifier.verifyDeploy(deploy);
                assert false;
            } catch (DeployVerificationException ex) {
                assert true;
            }
        }
    }

}
