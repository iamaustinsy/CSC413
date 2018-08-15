package interpreter;
import interpreter.bytecode.ByteCode;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump = false;
    
    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram() //Provided in pdf :D
    {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        
        while(isRunning)
        {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            //runStack.dump();
            pc++;
        }
    }
    
    public void setPC(int value)
    {
        pc = value;
    }
    
    public int getPC()
    {
        return pc;
    }
    
    public void setRunning(boolean running)
    {
        isRunning = running;
    }
    
    public boolean getRunning()
    {
        return isRunning;
    }
    
    public Integer popRetAddrs()
    {
        if(returnAddrs.size() == 0)
        {
            return 0;
        }
        else
        {
            return returnAddrs.pop();
        }
    }
    
    public void pushRetAddrs(int addrs)
    {
        returnAddrs.push(addrs);
    }
    
    public int vmPeek()
    {
        return runStack.peek();
    }
    
    public int vmPop()
    {
        return runStack.pop();
    }
    
    public void vmPush(int n)
    {
        runStack.push(n);
    }
    
    public Integer vmPush(Integer i)
    {
        return runStack.push(i);
    }
    
    public void vmFrameAt(int offset)
    {
        runStack.newFrameAt(offset);
    }
    
    public void vmPopFrame()
    {
        runStack.popFrame();
    }
    
    public int vmStore(int offset)
    {
        return runStack.store(offset);
    }
    
    public int vmLoad(int offset)
    {
        return runStack.load(offset);
    }
    
    public int getRunStackSize()
    {
        return runStack.getRunStackSize();
    }
    
    public RunTimeStack newRunTimeStack()
    {
        RunTimeStack runTimeStack = new RunTimeStack();
        return runTimeStack;
    }
    
    public Stack newReturnAddrsStack()
    {
        Stack returnStack = new Stack();
        return returnStack;
    }
    
    public void setDumpOn()
    {
        dump = true;
    }
    
    public void setDumpOff()
    {
        dump = false;
    }
    
}
