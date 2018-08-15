/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;
import java.util.*;
import interpreter.*;
/**
 *
 * @author iamaustinsy
 */
public class CallCode extends ByteCode
{
    private String label = "";
    private int targetAddrs;
    
    @Override
    public void init(ArrayList<String> args)
    {
        label = args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        vm.pushRetAddrs(vm.getPC());
        vm.setPC(targetAddrs);
    }
    
    @Override
    public String toString()
    {
        return "CALL" + label;
    }
    
    public String getLabel()
    {
        return label;
    }
    
    public void setLabel(String newLabel)
    {
        label = newLabel;
    }
    
    public int getTargetAddrs()
    {
        return targetAddrs;
    }
    
    public void setTargetAddrs(int newAddrs)
    {
        targetAddrs = newAddrs;
    }
}
