package net.elyland.cloud.domain;

import javax.persistence.*;

/**
 * Created by imaterynko on 17.01.17.
 */
@Entity
@Table(name = "server")
public class Server {
    @Id
    @Column(name = "ssh_user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "ip_address")
    private String ipaddress;

    @Column(name = "provider")
    private String provider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
