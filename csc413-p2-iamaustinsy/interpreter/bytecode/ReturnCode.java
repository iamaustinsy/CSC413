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
public class ReturnCode extends ByteCode 
{
    private String functionName = "";
    
    
    @Override
    public void init(ArrayList<String> args)
    {
        if(args.size() > 1)
        {
            functionName = args.get(1);
        }   
        
    }
    
    @Override 
    public void execute(VirtualMachine vm)
    {
        vm.vmPopFrame();    
        vm.setPC(vm.popRetAddrs());        
    }
    
    @Override
    public String toString()
    {
        return "RETURN " + functionName;
    }
}
