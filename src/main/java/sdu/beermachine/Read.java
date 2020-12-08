package sdu.beermachine;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Read extends TimerTask {

    static OpcUaClient client;

    static int produced;
    public static int amount_produce;
    //static Timer timer;


    public static void configUa() {

        try {

            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://127.0.0.1:4840").get();

            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), "127.0.0.1", 4840);

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
            cfg.setEndpoint(configPoint);

            client = OpcUaClient.create(cfg.build());
            client.connect().get();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/*
    public static void main(String[] args) {

        try {
            //configUa();
            timer = new Timer();
            timer.schedule(new Read(), 0, 1000);

            if (produced == amount_produce) {
                timer.cancel();
                timer.purge();
                return;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void getProduced() {
        try {
            NodeId nodeIdP = new NodeId(6, "::Program:product.produced");
            DataValue dataValueP = client.readValue(0, TimestampsToReturn.Both, nodeIdP).get();
            Variant variantP = dataValueP.getValue();
            produced = (UShort) variantP.getValue();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

        public static void getAmountProduced(){
            try {
                NodeId nodeIdAP = new NodeId(6, "::Program:product.produce_amount");
                DataValue dataValueAP = client.readValue(0, TimestampsToReturn.Both, nodeIdAP).get();
                Variant variantAP = dataValueAP.getValue();
                amount_produce = (UShort) variantAP.getValue();

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
*/

    @Override
    public String toString() {
        return String.valueOf(produced);
    }

    public String toString1(){
        return String.valueOf(amount_produce);
    }




    @Override
    public void run() {
        //    int producedInt = Integer.parseUnsignedInt(String.valueOf(produced));
        //    int amount_produceInt = Integer.parseUnsignedInt(String.valueOf(amount_produce));
        try {
                 configUa();
                 Timer timer = new Timer();


          //  for (int i = 0; i <= amount_produce; i++) {
                NodeId nodeIdAP = new NodeId(6, "::Program:product.produce_amount");
                NodeId nodeIdP = new NodeId(6, "::Program:product.produced");


                DataValue dataValueAP = client.readValue(0, TimestampsToReturn.Both, nodeIdAP).get();
                DataValue dataValueP = client.readValue(0, TimestampsToReturn.Both, nodeIdP).get();
                //      System.out.println("\n" + "Produced:" + "\n" + "DataValue = " + dataValueP);

                Variant variantAP = dataValueAP.getValue();
                Variant variantP = dataValueP.getValue();
                //    System.out.println("Variant = " + variantMS);

                //amount_produce = (UShort) variantAP.getValue();
                amount_produce = Integer.parseUnsignedInt(String.valueOf(variantAP.getValue()));
                // produced = (UShort) variantP.getValue();
                produced = Integer.parseUnsignedInt(String.valueOf(variantP.getValue()));
                System.out.println("produced = " + produced);
                //    System.out.println(amount_produce);

                //    if (produced.equals(amount_produce)) {
            if (produced == amount_produce) {
                timer.cancel();
                timer.purge();
                return;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
