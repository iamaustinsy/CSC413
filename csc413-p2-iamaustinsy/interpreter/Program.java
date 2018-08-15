package interpreter;

import java.util.*;
import java.util.ArrayList;
import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program; //Where all bytecodes are stored from source file

    public Program() {
        program = new ArrayList<>();
        
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    public void add(ByteCode code) //Function to add code from ByteCodeLoader class
    {
        program.add(code);
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() 
    {
        int branchAddress;
        //System.out.println(program.getSize());
        for (int i = 0; i < getSize(); i++){
            //System.out.println(i+1+": "+program.program.get(i));
            if (program.get(i) instanceof FalseBranchCode){
                FalseBranchCode br = (FalseBranchCode)program.get(i);
                branchAddress = LabelCode.get(br.getLabel());
                //System.out.println(branchAddress);
                br.setTargetAddrs(branchAddress);
            }
           
            if (program.get(i) instanceof GotoCode){
                GotoCode br = (GotoCode)program.get(i);
                branchAddress = LabelCode.get(br.getLabel());
                //System.out.println(br.returnLabel());
                //System.out.println(branchAddress);
                br.setTargetAddrs(branchAddress);
            }
            
            if (program.get(i) instanceof CallCode){
                CallCode br = (CallCode)program.get(i);
                branchAddress = LabelCode.get(br.getLabel());
                //System.out.println(branchAddress);
                br.setTargetAddrs(branchAddress);
            }
        }
        
    }

}
