package mes.service;

import mes.model.ConfigUa;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;


public class SetValues {

    public static void setBatchID(float valP0) {
        NodeId nodeIdP0 = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");
        ConfigUa.client.writeValue(nodeIdP0, DataValue.valueOnly(new Variant(valP0)));
    }

    public void setMachSpeed(float valMS) {

        NodeId nodeIdMS = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        ConfigUa.client.writeValue(nodeIdMS, DataValue.valueOnly(new Variant(valMS)));
    }

    public void setProductAmount(float valP2) {

        NodeId nodeIdP2 = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        ConfigUa.client.writeValue(nodeIdP2, DataValue.valueOnly(new Variant(valP2)));
    }

    public void setProductType(float valP1) {

        NodeId nodeIdP1 = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        ConfigUa.client.writeValue(nodeIdP1, DataValue.valueOnly(new Variant(valP1)));
    }

    public void setCntrlCmd(int valCC) {

        NodeId nodeIdCC = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        ConfigUa.client.writeValue(nodeIdCC, DataValue.valueOnly(new Variant(valCC)));
    }

    public void setCCR(boolean valCCR) {
        NodeId nodeIdCCR = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        ConfigUa.client.writeValue(nodeIdCCR, DataValue.valueOnly(new Variant(valCCR)));
    }

}
