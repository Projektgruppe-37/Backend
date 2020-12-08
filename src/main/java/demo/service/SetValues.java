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

public class SetValues {

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

    public void setProductAmount(float valP2) {
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
        NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        client.writeValue(nodeIdP2, DataValue.valueOnly(new Variant(valP2)));
        System.out.println("Parameter 2 = " + valP2);
    }

    public void setProductType(float valP1) {
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
        NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        client.writeValue(nodeIdP1, DataValue.valueOnly(new Variant(valP1)));
        System.out.println("Parameter 1 = " + valP1);
    }

    public void setCntrlCmd(int valCC) {
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
        NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        client.writeValue(nodeIdCC, DataValue.valueOnly(new Variant(valCC)));
        System.out.println("CntrlCmd = " + valCC);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean valCCR = true;
        NodeId nodeIdCCR = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        client.writeValue(nodeIdCCR, DataValue.valueOnly(new Variant(valCCR)));
        System.out.println("CmdChangeRequest = " + valCCR);
    }

}
