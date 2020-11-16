package sdu.beermachine;

import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;


public class Write {

    public static void main(String[] args) {
        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();
            System.out.println("Endpoints = " + endpoints);

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(endpoints.get(0));

            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();


            // CntrlCmd
            NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
            int valCC = 2;
            client.writeValue(nodeIdCC, DataValue.valueOnly(new Variant(valCC)));
            System.out.println("CntrlCmd = " + valCC);

            // MachSpeed
            NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");
            float valMS = 75;
            client.writeValue(nodeIdMS, DataValue.valueOnly(new Variant(valMS)));
            System.out.println("MachSpeed = " + valMS);

            // Parameter[0]
            NodeId nodeIdP0 = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");
            float valP0 = 1;
            client.writeValue(nodeIdP0, DataValue.valueOnly(new Variant(valP0)));
            System.out.println("Parameter 0 = " + valP0);

            // Parameter[1]
            NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
            float valP1 = 3;
            client.writeValue(nodeIdP1, DataValue.valueOnly(new Variant(valP1)));
            System.out.println("Parameter 1 = " + valP1);

            // Parameter[2]
            NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
            float valP2 = 100;
            client.writeValue(nodeIdP2, DataValue.valueOnly(new Variant(valP2)));
            System.out.println("Parameter 2 = " + valP2);

            Thread.sleep(1000);

            // CmdChangeRequest
            NodeId nodeIdCCR = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
            boolean valCCR = true;
            client.writeValue(nodeIdCCR, DataValue.valueOnly(new Variant(valCCR)));
            System.out.println("CmdChangeRequest = " + valCCR);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
