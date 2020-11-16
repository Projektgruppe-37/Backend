package sdu.beermachine;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.util.List;

public class Read {
    public static void main( String[] args )
    {
                try{
                    List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();
                    System.out.println("Endpoints = " + endpoints);

                    OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
                    cfg.setEndpoint(endpoints.get(0));

                    OpcUaClient client = OpcUaClient.create(cfg.build());
                    client.connect().get();


                    // Read the MachSpeed value of the nodeID = ns6;s=::Program:Cube.Command.MachSpeed
                    NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");

                    DataValue dataValueMS = client.readValue(0, TimestampsToReturn.Both, nodeIdMS).get();
                    System.out.println("\n" + "MachSpeed:" + "\n" + "DataValue = " + dataValueMS);

                    Variant variantMS = dataValueMS.getValue();
                    System.out.println("Variant = " + variantMS);

                    float machspeed = (float)variantMS.getValue();
                    System.out.println("Machspeed = " + machspeed);


                    // Read the CntrlCmd value of the nodeID = ns6;s=::Program:Cube.Command.CntrlCmd
                    NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");

                    DataValue dataValueCC = client.readValue(0, TimestampsToReturn.Both, nodeIdCC).get();
                    System.out.println("\n" + "CntrlCmd:" + "\n" + "DataValue = " + dataValueCC);

                    Variant variantCC = dataValueCC.getValue();
                    System.out.println("Variant = " + variantCC);

                    int cntrlcmd = (int)variantCC.getValue();
                    System.out.println("CntrlCmd = " + cntrlcmd);


                    // Read Parameter[0] = batch ID value of the nodeID = ::Program:Cube.Command.Parameter[0].Value
                    NodeId nodeIdP0 = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");

                    DataValue dataValueP0 = client.readValue(0, TimestampsToReturn.Both, nodeIdP0).get();
                    System.out.println("\n" + "Parameter[0]:" + "\n" + "DataValue = " + dataValueP0);

                    Variant variantP0 = dataValueP0.getValue();
                    System.out.println("Variant = " + variantP0);

                    int parameter0 = (int)variantP0.getValue();
                    System.out.println("Parameter[0] = " + parameter0);


                    // Read Parameter[1] = product type value of the nodeID = ::Program:Cube.Command.Parameter[1].Value
                    // 0: Pilsner, 1: Wheat, 2: IPA, 3: Stout, 4: Ale, 5: Alcohol free
                    NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");

                    DataValue dataValueP1 = client.readValue(0, TimestampsToReturn.Both, nodeIdP1).get();
                    System.out.println("\n" + "Parameter[1]:" + "\n" + "DataValue = " + dataValueP1);

                    Variant variantP = dataValueP1.getValue();
                    System.out.println("Variant = " + variantP);

                    int parameter1 = (int)variantP.getValue();
                    System.out.println("Parameter[0] = " + parameter1);


                    // Read Parameter[2] = amount of products in next batch value of the nodeID = ::Program:Cube.Command.Parameter[2].Value
                    NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");

                    DataValue dataValueP2 = client.readValue(0, TimestampsToReturn.Both, nodeIdP2).get();
                    System.out.println("\n" + "Parameter[2]:" + "\n" + "DataValue = " + dataValueP2);

                    Variant variantP2 = dataValueP1.getValue();
                    System.out.println("Variant = " + variantP2);

                    int parameter2 = (int)variantP.getValue();
                    System.out.println("Parameter[2] = " + parameter2);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
