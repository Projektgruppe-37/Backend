package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class LiveData extends ConfigUa {

    private final UUID id;

    private static int produced;
    private int amount;


    public LiveData(@JsonProperty("id") UUID id,
                    @JsonProperty("produced") int produced) {
        this.id = id;
        this.produced = produced;

    }

    public UUID getId() {
        return id;
    }


    public int getProducedLive() {
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
}

