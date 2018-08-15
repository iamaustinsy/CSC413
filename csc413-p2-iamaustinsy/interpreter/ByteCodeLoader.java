
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import interpreter.bytecode.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()
    { 
        try {
            program = new Program();
            String line, codeClass;
            StringTokenizer readLine;
            ByteCode byteCode = null;
            ArrayList<String> args = new ArrayList<String>();
            line = byteSource.readLine();
            while(line != null) {            
                
                StringTokenizer byteCodeLine = new StringTokenizer(line);
                String code = byteCodeLine.nextToken();
                codeClass = CodeTable.getClassName(code);
                
                args.clear();
                try {
                    byteCode = (ByteCode)(Class.forName("interpreter.bytecode." + codeClass).newInstance());
                    while(byteCodeLine.hasMoreTokens()) {
                        args.add(byteCodeLine.nextToken());
                    }
                     byteCode.init(args);
                     program.add(byteCode);
                
                }
                catch(Exception e) {
                    System.out.println(e);
                }

                line = byteSource.readLine();
                
            }  
            program.resolveAddrs();
            return program;
        } catch (IOException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return program;
    }
}
