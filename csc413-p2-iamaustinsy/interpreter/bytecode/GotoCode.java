/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;
import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author iamaustinsy
 */
public class GotoCode extends ByteCode
{
    private String label = "";
    private int targetAddrs;
    
    @Override
    public void init(ArrayList<String> args)
    {
        label = (String)args.get(0);
        if(args.size() > 1)
        {
            targetAddrs = Integer.parseInt(args.get(1));
        }
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        vm.setPC(targetAddrs);
    }
    
    @Override
     public String toString()
    {
        return "GOTO" + label;
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
