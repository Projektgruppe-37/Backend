package sdu.beermachine;

import demo.model.ConfigUa;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;



public class Write extends ConfigUa {

    public static void main(String[] args) {
        try {
            configUa();

            setMachSpeed(200);
            setBatchId(1);
            setProductType(0);
            setAmount(250);
            setCntrlCmd(2);

            Thread.sleep(2000);
            setValCCR(true);

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
