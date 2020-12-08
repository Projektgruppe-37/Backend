package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;
import sdu.beermachine.Read;

import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;



public class Batch {

    private final UUID id;
    private final int product_type;
    private int amount;
    private int produced;
    private final int accepted_products;
    private final int defect_products;
    private final int mach_speed;
    private final float humidity;
    private final float temperature;
    private final float vibration;
    private Timestamp created;
    static OpcUaClient client;
    private Timer timer;
    private Read read;


    public Batch(@JsonProperty("id") UUID id,
                 @JsonProperty("product_type") int product_type,
                 @JsonProperty("amount") int amount,
                 @JsonProperty("produced") int produced,
                 @JsonProperty("accepted_products") int accepted_products,
                 @JsonProperty("defect_products") int defect_products,
                 @JsonProperty("mach_speed") int mach_speed,
                 @JsonProperty("humidity") float humidity,
                 @JsonProperty("temperature") float temperature,
                 @JsonProperty("vibration") float vibration,
                 @JsonProperty("created") Timestamp created)
    {

        this.id = id;
        this.product_type = product_type;
        this.amount = amount;
        this.produced = produced;
        this.accepted_products = accepted_products;
        this.defect_products = defect_products;
        this.mach_speed = mach_speed;
        this.humidity = humidity;
        this.temperature = temperature;
        this.vibration = vibration;
        this.created = created;
    }
/*
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
*/

    public UUID getId() {
        return id;
    }

    public int getProductType() {
        return product_type;
    }

    public int getAmount() {
        return amount;
    }

    public int getProduced() {
        read = new Read();
        //configUa();
        timer = new Timer();
        timer.schedule(new Read(), 0, 1000);
      return Integer.parseInt(read.toString());

    }

    public int getAcceptedProducts() {
        return accepted_products;
    }

    public int getDefectProducts() {
        return defect_products;
    }

    public int getMachSpeed() {
        return mach_speed;
    }

    public float getHumidity() { return humidity; }

    public float getTemperature() {
        return temperature;
    }

    public float getVibration() {
        return vibration;
    }

    public Timestamp getCreated() {
        created = new Timestamp(System.currentTimeMillis());
        return created;
    }

 /*   @Override
    public void run() {
        try {
            NodeId nodeIdAP = new NodeId(6, "::Program:product.produce_amount");
            NodeId nodeIdP = new NodeId(6, "::Program:product.produced");


            DataValue dataValueAP = client.readValue(0, TimestampsToReturn.Both, nodeIdAP).get();
            DataValue dataValueP = client.readValue(0, TimestampsToReturn.Both, nodeIdP).get();

            Variant variantAP = dataValueAP.getValue();
            Variant variantP = dataValueP.getValue();

            amount = Integer.parseUnsignedInt(String.valueOf(variantAP.getValue()));
            produced = Integer.parseInt(String.valueOf(variantP.getValue()));
//            System.out.println("produced = " + produced);
//            System.out.println(amount_produce);

            if (produced == amount) {
                timer.cancel();
                timer.purge();
                return;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
}

