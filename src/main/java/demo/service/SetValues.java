package demo.service;

import demo.model.ConfigUa;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;


public class SetValues {

    public void setMachSpeed(float valMS) {

        System.out.println("MachSpeed = " + valMS);
        NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        ConfigUa.client.writeValue(nodeIdMS, DataValue.valueOnly(new Variant(valMS)));
    }

    public void setProductAmount(float valP2) {

        NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        ConfigUa.client.writeValue(nodeIdP2, DataValue.valueOnly(new Variant(valP2)));
        System.out.println("Parameter 2 = " + valP2);
    }

    public void setProductType(float valP1) {

        NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        ConfigUa.client.writeValue(nodeIdP1, DataValue.valueOnly(new Variant(valP1)));
        System.out.println("Parameter 1 = " + valP1);
    }

    public void setCntrlCmd(int valCC) {

        NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        ConfigUa.client.writeValue(nodeIdCC, DataValue.valueOnly(new Variant(valCC)));
        System.out.println("CntrlCmd = " + valCC);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean valCCR = true;
        NodeId nodeIdCCR = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        ConfigUa.client.writeValue(nodeIdCCR, DataValue.valueOnly(new Variant(valCCR)));
        System.out.println("CmdChangeRequest = " + valCCR);
    }

}
