/*package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;
//import sdu.beermachine.Read;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class LiveData extends TimerTask {


    private final UUID id;
    private static OpcUaClient client;
    private static int produced;
    private static int amount_produce;
    private static Timer timer;

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

    public LiveData(@JsonProperty UUID id,
                    @JsonProperty int produced) {
        this.id = id;
        this.produced = produced;
    }

    public UUID getId() {
        return id;
    }


    public int getProducedLive() {
        configUa();
        timer = new Timer();
        timer.schedule(new Read(), 0, 1000);

        return produced;
    }

    @Override
    public void run() {
        try {
            NodeId nodeIdAP = new NodeId(6, "::Program:product.produce_amount");
            NodeId nodeIdP = new NodeId(6, "::Program:product.produced");


            DataValue dataValueAP = client.readValue(0, TimestampsToReturn.Both, nodeIdAP).get();
            DataValue dataValueP = client.readValue(0, TimestampsToReturn.Both, nodeIdP).get();

            Variant variantAP = dataValueAP.getValue();
            Variant variantP = dataValueP.getValue();

            amount_produce = Integer.parseUnsignedInt(String.valueOf(variantAP.getValue()));
            produced = Integer.parseInt(String.valueOf(variantP.getValue()));
//            System.out.println("produced = " + produced);
//            System.out.println(amount_produce);

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

*/