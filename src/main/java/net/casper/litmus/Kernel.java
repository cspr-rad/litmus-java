/*
 * This source file was generated by the Gradle 'init' task
 */
package net.casper.litmus;

import com.casper.sdk.model.block.JsonBlockHeader;
import com.casper.sdk.model.common.Digest;
import com.casper.sdk.model.deploy.EraInfo;
import com.casper.sdk.model.key.PublicKey;
import com.casper.sdk.model.key.Signature;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Optional;

public class Kernel {

    @Getter
    @Setter
    public static class ParentHashAndCurrentHeight {
        Digest parentHash;
        long currentHeight;
    }

    @Getter
    @Setter
    public static class BlockSignatures {
        Digest blockHash;
        Long eraId;
        Map<PublicKey, Signature> proofs;
    }

    @Getter
    @Setter
    public static class BlockHeaderWithSignatures {
        JsonBlockHeader blockHeader;
        BlockSignatures blockSignatures;
    }

    private Digest latestBlockHash;
    private EraInfo eraInfo;
    private ParentHashAndCurrentHeight parentHashAndCurrentHeight;

    public Kernel(final Digest latestBlockHash) {
        this.latestBlockHash = latestBlockHash;
        this.eraInfo = null;
        this.parentHashAndCurrentHeight = null;
    }

    public void update(final BlockHeaderWithSignatures blockHeaderWithSignatures) {

        var blockHeader = blockHeaderWithSignatures.getBlockHeader();
       /* latestBlockHash = blockHeaderWithSignatures.getHash();
        parentHashAndCurrentHeight = new ParentHashAndCurrentHeight();
        parentHashAndCurrentHeight.parentHash = blockHeaderWithSignatures.getParentHash();
        parentHashAndCurrentHeight.currentHeight = blockHeaderWithSignatures.getHeight();
        eraInfo = blockHeaderWithSignatures.getEraInfo();*/
    }

    public Digest getLatestBlockHash() {
        return latestBlockHash;
    }

    public ParentHashAndCurrentHeight getParentHashAndCurrentHeight() {
        return parentHashAndCurrentHeight;
    }

    public Optional<EraInfo> getEraInfo() {
        return Optional.ofNullable(eraInfo);
    }
}