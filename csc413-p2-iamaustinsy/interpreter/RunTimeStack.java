package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    public void dump() //FIX DUMP
    {
        System.out.print("[");
        for (int i = 0; i < runTimeStack.size(); i++)
        {
            if (i != 0 && framePointer.contains(i))
            {
                System.out.print("] [");
            }
            if (i != 0)
            {
                System.out.print(",");
            }
            System.out.print(runTimeStack.get(i));
        }        
        System.out.println("]");
    }
    
    public int peek()
    {
        return (int) runTimeStack.get(runTimeStack.size() - 1);
    }
    
    public int pop()
    {
        int pop = (Integer)runTimeStack.get(runTimeStack.size() - 1);
        return (Integer)runTimeStack.remove(pop);
        
    }
    
    public int push(int i)
    {
        runTimeStack.add(i);
        return i;
    }
    
    public void newFrameAt(int offset)
    {
        int value = runTimeStack.size() - offset;
        if(value < 0)
        {
            return;
        }
        else
        {
            framePointer.push(value);
        }
    }
    
    public void popFrame()
    {
        if(runTimeStack.size() == 0)
        {
            return;
        }
        int returnVal = (Integer) runTimeStack.get(runTimeStack.size() - 1);
        if(framePointer.size() == 0)
        {
            return;
        }
        int frameIndex = framePointer.pop();
        int numOfRem = runTimeStack.size() - frameIndex;
        for(int i = 0; i < numOfRem; i++)
        {
            runTimeStack.remove(frameIndex);
        }
        runTimeStack.add(returnVal);
    }
      
    public int store(int offset)
    {
        int store = (int)runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, store);
        return store;
    }
    
    public int load(int offset)
    {
        int frameStart = (framePointer.peek()).intValue();
        int index = frameStart + offset;
        Integer newValue = (Integer)runTimeStack.get(index);
        push(newValue);
        return newValue.intValue();
    }
    
    public Integer push(Integer val)
    {
        runTimeStack.add(val);
        return val;
    }
    
    public int getRunStackSize()
    {
        return runTimeStack.size();
    }
    
    
}
