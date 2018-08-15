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
public class WriteCode extends ByteCode
{
    private int targetAddrs;
    
    @Override
    public void init(ArrayList<String> args)
    {}
    
    @Override
    public void execute(VirtualMachine vm)
    {
        int value = vm.vmPeek();
        System.out.println(value);
    }
    
    @Override
    public String toString()
    {
        return "WRITE";
    }
}
