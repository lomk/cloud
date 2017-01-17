package net.elyland.cloud.services;

import net.elyland.cloud.domain.Server;
import net.elyland.cloud.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by imaterynko on 17.01.17.
 */
public class ServerServiceImpl implements ServerService {

    @Autowired
    ServerRepository serverRepository;

    @Override
    public Iterable<Server> listAllServers(){
        return serverRepository.findAll();
    }
    @Override
    public Server getServerById(Integer id){
        return serverRepository.getOne(id);
    }

    @Override
    public void deleteServer(Integer id){
        serverRepository.delete(id);
    }

    @Override
    public void save(Server server){
        serverRepository.save(server);
    }

    @Override
    public Server findByHostname(String hostname){
        return serverRepository.findByHostname(hostname);
    }
    @Override
    public Server findByIpAddress(String ipAddress){
        return serverRepository.findByIpAddress(ipAddress);
    }
}
