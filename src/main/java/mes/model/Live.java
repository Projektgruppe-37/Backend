package mes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;


public class Live extends ConfigUa {

    private int maintenance;
    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;
    private int batchId;
    private float productType;
    private float amount;
    private int produced;
    private int acceptedProducts;
    private int defectProducts;
    private float machSpeed;
    private float humidity;
    private float temperature;
    private float vibration;


    public Live(@JsonProperty("maintenance") int maintenance,
                @JsonProperty("barley") float barley,
                @JsonProperty("hops") float hops,
                @JsonProperty("malt") float malt,
                @JsonProperty("wheat") float wheat,
                @JsonProperty("yeast") float yeast,
                @JsonProperty("batch_id") int batchId,
                @JsonProperty("product_type") float productType,
                @JsonProperty("amount") float amount,
                @JsonProperty("produced") int produced,
                @JsonProperty("accepted_products") int acceptedProducts,
                @JsonProperty("defect_products") int defectProducts,
                @JsonProperty("mach_speed") float machSpeed,
                @JsonProperty("humidity") float humidity,
                @JsonProperty("temperature") float temperature,
                @JsonProperty("vibration") float vibration) {

        this.maintenance = maintenance;
        this.barley = barley;
        this.hops = hops;
        this.malt = malt;
        this.wheat = wheat;
        this.yeast = yeast;
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
    }

    public int getMaintenance() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Maintenance.Counter");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            maintenance = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

            //         System.out.println("Maintenance = " + maintenance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maintenance;
    }


    public float getBarley() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Barley");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            barley = (float) variant.getValue();

   //         System.out.println("Barley = " + barley);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return barley;
    }
    public float getHops() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Hops");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            hops = (float) variant.getValue();

    //        System.out.println("Hops = " + hops);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hops;
    }

    public float getMalt() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Malt");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            malt = (float) variant.getValue();

    //        System.out.println("Malt = " + malt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return malt;
    }

    public float getWheat() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Wheat");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            wheat = (float) variant.getValue();

    //        System.out.println("Wheat = " + wheat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return wheat;
    }

    public float getYeast() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:Inventory.Yeast");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            yeast = (float) variant.getValue();

    //        System.out.println("Yeast = " + yeast);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return yeast;
    }

    public int getBatchId() {
        try {

            NodeId nodeId = new NodeId(6, "::Program:batch_id");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            batchId = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

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

            NodeId nodeId = new NodeId(6, "::Program:product.produced");
            DataValue dataValue = ConfigUa.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            produced = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

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
}

