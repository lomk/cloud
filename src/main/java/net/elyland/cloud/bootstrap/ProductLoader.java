package net.elyland.cloud.bootstrap;

/**
 * Created by Igor on 07-Jun-16.
 */

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.Server;
import net.elyland.cloud.domain.VirtualMachineAction;
import net.elyland.cloud.repositories.HypervisorRepository;
import net.elyland.cloud.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

/*    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/


    @Autowired
    HypervisorRepository hypervisorRepository;

    @Autowired
    ServerRepository serverRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        Hypervisor hpv = new Hypervisor();
        hpv.setHostname("localhost");
        hpv.setCloudIPAdress("192.168.122.1");
        hpv.setHvIPAdress("192.168.122.1");
        hpv.setExternalIPAdress("127.0.0.1");
        hypervisorRepository.save(hpv);

        Server server = new Server();
        server.setHostname("localhost");
        server.setIpaddress("127.0.0.1");
        server.setProvider("local");
        serverRepository.save(server);


/*        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());*/
    }
}
