package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;



public class Batch extends ConfigUa{

    private final UUID id;
    private final int product_type;
    public static int amount;
    static int produced;
    private final int accepted_products;
    private final int defect_products;
    private final int mach_speed;
    private final float humidity;
    private final float temperature;
    private final float vibration;
    private Timestamp created;



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

        Timer timer = new Timer();
        final TimerTask task = new TimerTask() {


            @Override
            public void run() {

                try {


                    NodeId nodeIdAP = new NodeId(6, "::Program:product.produce_amount");
                    NodeId nodeIdP = new NodeId(6, "::Program:product.produced");

                    DataValue dataValueAP = client.readValue(0, TimestampsToReturn.Both, nodeIdAP).get();
                    DataValue dataValueP = client.readValue(0, TimestampsToReturn.Both, nodeIdP).get();

                    Variant variantAP = dataValueAP.getValue();
                    Variant variantP = dataValueP.getValue();

                    amount = Integer.parseUnsignedInt(String.valueOf(variantAP.getValue()));
                    produced = Integer.parseUnsignedInt(String.valueOf(variantP.getValue()));

                    System.out.println("produced = " + produced);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                    if (produced == amount) {
                        timer.cancel();
                        timer.purge();
                        //return;

                    }
                }
            };
                timer.schedule(task, 0, 1000);

      return produced;

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

}

