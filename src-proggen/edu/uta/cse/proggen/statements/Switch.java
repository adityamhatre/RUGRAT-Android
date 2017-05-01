package edu.uta.cse.proggen.statements;

import java.util.ArrayList;
import java.util.Random;

import edu.uta.cse.proggen.classLevelElements.Method;
import edu.uta.cse.proggen.classLevelElements.Type.Primitives;
import edu.uta.cse.proggen.expressions.VariableBinOpField;
import edu.uta.cse.proggen.expressions.VariableBinOpVariable;
import edu.uta.cse.proggen.nodes.Expression;
import edu.uta.cse.proggen.packageLevelElements.ClassGenerator;


/**
 * This creates the switch statement.
 *
 * @author Ishtiaque_Hussain
 */
public class Switch extends Statement {

    Expression operand = null;
    ArrayList<String> cases = new ArrayList<String>();
    String output;

    public Switch(Method method, ArrayList<ClassGenerator> classList) {
        Random rand = new Random();
        //introducing fields in the switch statement
        if (rand.nextInt(2) == 0)
            operand = new VariableBinOpField(
                    method, Primitives.INT);
        else
            operand = new VariableBinOpVariable(method,
                    Primitives.INT);

        method.setLoc(method.getLoc() + 2);

        int option = rand.nextInt(100) % 10; //switches will have maximum of 10 cases.

        //We don't want switch to have 0, 1 or only 2 cases
        if (option <= 2)
            option += 2;

        for (int i = 0; i < option; i++) {
            cases.add("case " + i + ":\n" + Statement.getRandomizedStatement(method, classList).toString() + " break;\n");
            method.setLoc(method.getLoc() + 2);
            //Start.loc_per_meth_counter += 2; // each case adds 2 lines 'case:' and 'break'
        }
        cases.add("default :\n" + Statement.getRandomizedStatement(method, classList).toString());
    }

    public Switch(ArrayList<String> variables) {
        Random random = new Random(System.currentTimeMillis());
        StringBuffer stringBuffer = new StringBuffer();
        //int value = random.nextInt(5);

        int looper = (random.nextInt(variables.size()));
        stringBuffer.append("switch(" + variables.get(looper) + "){");
        int variableValue = random.nextInt(19);
        for (int i = 0; i < variableValue; i++) {
            stringBuffer.append("case " + i + ":System.out.println(\"In switch statement, case " + i + ": \"+(" + random.nextInt(100) + "+" + random.nextInt(100) + "));\nbreak;\n ");
        }

        stringBuffer.append("default:System.out.println(\"In default case: \"+(" + random.nextInt(100) + "+" + random.nextInt(100) + "));\nbreak;\n }");
        output = stringBuffer.toString();
    }


    public String toString() {
        String output = "switch(" + operand.toString() + "){\n";
        for (int i = 0; i < cases.size(); i++) {
            output += cases.get(i);
        }
        output += "}\n";

        return output;
    }

    public String generate() {
        return output;
    }
}
