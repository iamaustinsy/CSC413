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
public class PopCode extends ByteCode
{
    private int value;
    
    @Override
    public void init(ArrayList<String> args)
    {
        value = Integer.parseInt(args.get(0));
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        for(int i = 0; i < value; i++)
        {
            vm.vmPop();
        }
    }
    
    @Override
    public String toString()
    {
        return "POP " + value;
    }
    
    public int getNumPop()
    {
        return value;
    }
}
