package mes.model;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigUa {
    public static OpcUaClient client;

    @EventListener(ApplicationReadyEvent.class)
    public void configUa() {

        try {
// Used when running the application with ARSim launching with main or BreweryMES-1.0-SIMUALATION-IDE.jar
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();
            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "127.0.0.1", 4840);

// Used when running the application with ARSim launching through Docker
//            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://docker.for.win.localhost:4840").get();
//            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "docker.for.win.localhost", 4840);

// USed when running the physical simulator launching through Docker and main or BreweryMES-1.0-PHYSICAL-IDE.jar
//            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://192.168.0.122:4840").get();
//            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "192.168.122", 4840);

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(configPoint);

            client = OpcUaClient.create(cfg.build());
            client.connect().get();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
