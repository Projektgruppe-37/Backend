package sdu.beermachine;

import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

public class Write {

    public static OpcUaClient client;

    public Write() {
        try {
            configUa();
            Thread.sleep(2000);
            setValCCR(true);

/*    _______________________________________________________________________________________________________________
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

//--------------------------------------------------------------------------------------------------------------------*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        setMachSpeed(400);
    }

    public static void configUa(){

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
    }


    public static void setValCCR(boolean valCCR) {
        NodeId nodeIdCCR = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        client.writeValue(nodeIdCCR, DataValue.valueOnly(new Variant(valCCR)));
        System.out.println("CmdChangeRequest = " + valCCR);
    }


    public static void setCntrlCmd(int valCC) {
        NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        client.writeValue(nodeIdCC, DataValue.valueOnly(new Variant(valCC)));
        System.out.println("CntrlCmd = " + valCC);
    }

    public static void setMachSpeed(float valMS) {
        System.out.println("MachSpeed = " + valMS);
        NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        System.out.println(client);
        client.writeValue(nodeIdMS, DataValue.valueOnly(new Variant(valMS)));
    }

    // Parameter[0]
    public static void setBatchId(float valP0) {
        NodeId nodeIdP0 = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");
        client.writeValue(nodeIdP0, DataValue.valueOnly(new Variant(valP0)));
        System.out.println("Parameter 0 = " + valP0);
    }


    // Parameter[1]

    public static void setProductType(float valP1) {
        NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        client.writeValue(nodeIdP1, DataValue.valueOnly(new Variant(valP1)));
        System.out.println("Parameter 1 = " + valP1);
    }


    // Parameter[2]

    public static void setAmount(float valP2) {
        NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        client.writeValue(nodeIdP2, DataValue.valueOnly(new Variant(valP2)));
        System.out.println("Parameter 2 = " + valP2);
    }

}
