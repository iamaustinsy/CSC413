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
public abstract class DumpCode extends ByteCode
{
    private String dump;
    
    @Override
    public void init(ArrayList<String> args)
    {
        dump = args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        if(dump.equals("ON"))
        {
            vm.setDumpOn();
        }
        if(dump.equals("OFF"))
        {
            vm.setDumpOff();
        }
    }
    
    @Override
    public String toString()
    {
        return "DUMP" + dump;
    }

}
