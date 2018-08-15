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
public class ArgsCode extends ByteCode
{
    private int numArg;
    
    @Override
    public void init(ArrayList<String> args)
    {
        numArg = Integer.parseInt(args.get(0));
    }
    @Override
    public void execute(VirtualMachine vm)
    {
        vm.vmFrameAt(numArg);
    }
    @Override
    public String toString()
    {
        return "ARGS " + numArg;
    }
}
