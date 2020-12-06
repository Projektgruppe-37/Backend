package demo.service;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

import java.util.List;

public class MachSpeedTest {

    private static OpcUaClient client;

    public void setMachSpeed(float valMS) {
        try {

            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();
            //System.out.println("Endpoints = " + endpoints);


            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "127.0.0.1", 4840);

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(configPoint);
            // cfg.setEndpoint(endpoints.get(0));

            client = OpcUaClient.create(cfg.build());
            client.connect().get();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("MachSpeed = " + valMS);
        NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        client.writeValue(nodeIdMS, DataValue.valueOnly(new Variant(valMS)));
    }

    public float getMachSpeed() {

        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();


            // Read the MachSpeed value of the nodeID = ns6;s=::Program:Cube.Command.MachSpeed
            NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");

            DataValue dataValueMS = client.readValue(0, TimestampsToReturn.Both, nodeIdMS).get();

            Variant variantMS = dataValueMS.getValue();

            float machspeed = (float) variantMS.getValue();

            return machspeed;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
