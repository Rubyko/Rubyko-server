package com.rubyko.shared.peer.net;

import com.rubyko.shared.common.net.model.PeerServerInfo;

import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public interface PeerUserNetInfoUpdater extends Serializable {
    void update(PeerServerInfo peerServerInfo);
}
