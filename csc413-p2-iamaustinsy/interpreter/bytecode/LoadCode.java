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
public class LoadCode extends ByteCode
{
    private int value;
    private String id;
    
    @Override
    public void init(ArrayList<String> args)
    {
        value = Integer.parseInt(args.get(0));
        id = args.get(1);
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        vm.vmLoad(value);
    }
    
    @Override
    public String toString()
    {
        return "LOAD " + value + " " + id;
    }
}
