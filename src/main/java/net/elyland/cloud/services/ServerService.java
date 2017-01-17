package net.elyland.cloud.services;

import net.elyland.cloud.domain.Server;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface ServerService {
    Iterable<Server> listAllServers();

    Server getServerById(Integer id);

    void deleteServer(Integer id);

    void save(Server server);

    Server findByHostname(String hostname);

    Server findByIpAddress(String ipAddress);
}
