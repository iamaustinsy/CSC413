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
public class LabelCode extends ByteCode
{
    private String label;
    
    @Override
    public void init(ArrayList<String> args)
    {
        label = (String)args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {}
    
    @Override
    public String toString()
    {
        return "LABEL" + label;
    }
    
    public String getLabel()
    {
        return label;
    }
}
