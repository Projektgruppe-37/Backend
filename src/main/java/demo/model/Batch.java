package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

import java.sql.Timestamp;
import java.util.UUID;


public class Batch {

    private final UUID id;
    private float batchId;
    private float productType;
    private float amount;
    private int produced;
    private int acceptedProducts;
    private int defectProducts;
    private float machSpeed;
    private float humidity;
    private float temperature;
    private float vibration;
    private Timestamp created;


    public Batch(@JsonProperty("id") UUID id,
                 @JsonProperty("batch_id") float batchId,
                 @JsonProperty("product_type") float productType,
                 @JsonProperty("amount") float amount,
                 @JsonProperty("produced") int produced,
                 @JsonProperty("accepted_products") int acceptedProducts,
                 @JsonProperty("defect_products") int defectProducts,
                 @JsonProperty("mach_speed") float machSpeed,
                 @JsonProperty("humidity") float humidity,
                 @JsonProperty("temperature") float temperature,
                 @JsonProperty("vibration") float vibration,
                 @JsonProperty("created") Timestamp created) {

        this.id = id;
        this.batchId = batchId;
        this.productType = productType;
        this.amount = amount;
        this.produced = produced;
        this.acceptedProducts = acceptedProducts;
        this.defectProducts = defectProducts;
        this.machSpeed = machSpeed;
        this.humidity = humidity;
        this.temperature = temperature;
        this.vibration = vibration;
        this.created = created;

    }


    public UUID getId() {
        return id;
    }

    public float getBatchId() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.Parameter[0].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            batchId = (float) variant.getValue();

    //        System.out.println("Product Type = " + batchId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return batchId;
    }

    public float getProductType() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.Parameter[0].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            productType = (float) variant.getValue();

    //        System.out.println("Product Type = " + productType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productType;
    }

    public float getAmount() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[1].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            amount = (float) variant.getValue();

    //        System.out.println("Amount = " + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return amount;
    }

    public int getProduced() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.ProdProcessedCount");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            produced = (int) variant.getValue();

    //        System.out.println("Produced = " + produced);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return produced;

    }

    public int getAcceptedProducts() {

        acceptedProducts = produced - defectProducts;
    //    System.out.println("Accepted Products = " + acceptedProducts);

        return acceptedProducts;
    }

    public int getDefectProducts() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Admin.ProdDefectiveCount");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            defectProducts = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

    //        System.out.println("Defect Products = " + defectProducts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return defectProducts;
    }

    public float getMachSpeed() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.MachSpeed");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            machSpeed = (float) variant.getValue();

    //        System.out.println("Machine Speed = " + machSpeed);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return machSpeed;
    }

    public float getHumidity() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[2].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            humidity = (float) variant.getValue();

    //        System.out.println("Humidity = " + humidity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return humidity;
    }

    public float getTemperature() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[3].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            temperature = (float) variant.getValue();

    //        System.out.println("Temperature = " + temperature);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return temperature;
    }

    public float getVibration() {

        try {

            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.Parameter[4].Value");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            vibration = (float) variant.getValue();

    //        System.out.println("Vibration = " + vibration);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vibration;
    }

    public Timestamp getCreated() {
        created = new Timestamp(System.currentTimeMillis());
        return created;
    }
}

