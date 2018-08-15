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
public class BopCode extends ByteCode
{
    String binaryOperator = "";
    @Override
    public void init(ArrayList<String> args)
    {
        binaryOperator = (String)args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm)
    {
        if(binaryOperator.equals("+"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int sum = temp2 + temp1;
            vm.vmPush(sum);
        }
        else if(binaryOperator.equals("-"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int dif = temp2 - temp1;
            vm.vmPush(dif);
        }
        else if(binaryOperator.equals("/"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int div = temp2 / temp1;
            vm.vmPush(div);
        }
        else if(binaryOperator.equals("*"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int product = temp2 * temp1;
            vm.vmPush(product);
        }
        else if(binaryOperator.equals("=="))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int equals = 0;
            if(temp1 == temp2)
            {
                equals = 1;
            }
            vm.vmPush(equals);
        }
        else if(binaryOperator.equals("!="))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int notEqual = 0;
            if(temp1 != temp2)
            {
                notEqual = 1;
            }
            vm.vmPush(notEqual);
        }
        else if(binaryOperator.equals(">="))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int greaterThanEqual = 0;
            if(temp2 >= temp1)
            {
                greaterThanEqual = 1;
            }
            vm.vmPush(greaterThanEqual);
        }
        else if(binaryOperator.equals("<="))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int lessThanEqual = 0;
            if(temp2 <= temp1)
            {
                lessThanEqual = 1;
            }
            vm.vmPush(lessThanEqual);
        }
        else if(binaryOperator.equals(">"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int greaterThan = 0;
            if(temp2 > temp1)
            {
                greaterThan = 1;
            }
            vm.vmPush(greaterThan);
        }
        else if(binaryOperator.equals("<"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int lessThan = 0;
            if(temp2 < temp1)
            {
                lessThan = 1;
            }
            vm.vmPush(lessThan);
        }
        else if(binaryOperator.equals("|"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int or = 0;
            if(temp2 == 1 || temp1 == 1)
            {
                or = 1;
            }
            vm.vmPush(or);
        }
        else if(binaryOperator.equals("&"))
        {
            int temp1 = vm.vmPop();
            int temp2 = vm.vmPop();
            int and = 0;
            if(temp2 == 1 && temp1 == 1)
            {
                and = 1;
            }
            vm.vmPush(and);
        }
    }
    @Override
    public String toString()
    {
        return "BOP" + binaryOperator;
    }
    
}
