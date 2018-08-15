/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;
import java.util.*;
import interpreter.VirtualMachine;
import java.util.ArrayList;
/**
 *
 * @author iamaustinsy
 */
public class ReadCode extends ByteCode
{
    private int input;
    @Override
    public void init(ArrayList<String> args)
    {}
    
    @Override
    public void execute(VirtualMachine vm)
    {    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value: ");
        input = scanner.nextInt();
        vm.vmPush(input); 
    }
    
    @Override
    public String toString()
    {
        return "READ";
    }
}
