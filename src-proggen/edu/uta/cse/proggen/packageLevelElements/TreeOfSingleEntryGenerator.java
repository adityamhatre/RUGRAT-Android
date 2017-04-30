package edu.uta.cse.proggen.packageLevelElements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import edu.uta.cse.proggen.classLevelElements.AndroidMethods;
import edu.uta.cse.proggen.classLevelElements.Method;
import edu.uta.cse.proggen.configurationParser.ConfigurationXMLParser;
import edu.uta.cse.proggen.statements.IfStmtIfStmt;
import edu.uta.cse.proggen.statements.PrintStatement;
import edu.uta.cse.proggen.util.ProgGenUtil;

/**
 * Creates Single entry classes in a tree structure.
 * For X number of generated classes, it will create Y number of SingleEntry class
 * such that Y = X/150. That is, each of Y classes will call 150 SingleEntry methods
 * of generated classes; this is the leaf level.
 * <p>
 * Then at the higher level, Z = Y/150, number of classes will call 150 each.
 * <p>
 * So, the tree depth is: Log150(X) =  Log(X) / Log(150);
 *
 * @author Ishtiaque Hussain {ishtiaque.hussain@mavs.uta.edu}
 */

public class TreeOfSingleEntryGenerator {

    private ArrayList<ClassGenerator> listOfClasses;
    private final double methCallLimit = 150;
    private final String DirPath;
    private final String formalParam;
    private final String argument;

    private int LEVEL;

    public TreeOfSingleEntryGenerator(ArrayList<ClassGenerator> list, String pathToDir) {
        listOfClasses = list;
        DirPath = pathToDir;
        LEVEL = (int) Math.ceil(Math.log10(listOfClasses.size()) / Math.log10(methCallLimit));
        formalParam = formalParamBuilder();
        argument = argBuilder();
    }


    /**
     * Tree of entry Classes
     */
    public void generateTreeOfSingleEntryClass() {
        System.out.println("Writing SingleEntry classes...");
        createClass(0, listOfClasses.size());
        System.out.println("Successfully written!!");
    }

    /**
     * Creates String of {int i0, int i1, int i2, ...}
     *
     * @return int i0, int i1, int i2, int i3, ...
     */
    private String formalParamBuilder() {

        StringBuilder param = new StringBuilder();
        for (int j = 0; j < ProgGenUtil.maxNoOfParameters; j++)
            param.append("int i" + j + ",");

        String st = param.toString();
        st = st.substring(0, st.length() - 1);

        return st;
    }

    /**
     * @return argument of a method, e.g., f1, f2, f3, f4, f5, f6
     */

    private String argBuilder() {
        StringBuilder fields = new StringBuilder();
        for (int j = 0; j < ProgGenUtil.maxNoOfParameters; j++) {
            fields.append("f" + j + ",");
        }
        String f = fields.toString();
        f = f.substring(0, fields.length() - 1);

        return f;

    }

    private void createClass(int level, int target) {
        if (level == 0) {

			/*
             * create 'loop' number of classes where each class calls 150 or
			 * less T.SingleEntry() methods in total 'target' number of
			 * T.SingleEntry() methods name these classes TStart_Llevel_X
			 */


            int count = 0;
            int loop = (int) Math.ceil((double) target / 150);

            for (int i = 0; i < loop; i++) {

                try {
                    File file = new File(DirPath +
                            "TestPrograms" + File.separator +
                            "com" + File.separator +
                            "advancedse" + File.separator + "project"
                            + File.separator + "TStart_L" + level + "_" + i + ".java");


                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter writer = new BufferedWriter(fileWriter);

                    StringBuffer output = new StringBuffer();

                    output.append("package com.advancedse.project;\n\n");
                    output.append("public class TStart_L" + level + "_" + i + "{\n");
                    for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                        output.append("private static int f" + k + ";\n");
                    }

                    output.append("\n\n");
                    output.append("public static void entryMethod(");
                    //int i0, int i1, int i2, int i3, int i4, int i5, int i6){\n");
                    output.append(formalParam + "){\n");

                    for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                        output.append("f" + k + " = " + "i" + k + ";\n");
                    }


                    for (int j = 0; j < methCallLimit && count < target; j++, count++) {
                        // call Tj.SingleEntry();
//						output.append("FiveMLOC"+count+".singleEntry(f0,f1,f2,f3,f4,f5,f6);\n");
                        output.append(ConfigurationXMLParser.getProperty("classNamePrefix") + count + ".singleEntry(" + argument + ");\n");
                    }

                    output.append("}\n}");

                    String out = output.toString();
//					System.out.println("Writing L0 level entry classes.");

                    writer.write(out);
                    writer.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            createClass(level + 1, loop);

        } else {
            if (level == LEVEL) {
                // create FiveMLOCStart.java class that will call
                // FiveMLOCStart_L(prevLevel)_0.entryMethod();
                try {
                    File file = new File(DirPath +
                            "TestPrograms" + File.separator +
                            "com" + File.separator +
                            "advancedse" + File.separator + "project"
                            + File.separator + ConfigurationXMLParser.getProperty("classNamePrefix") + "Start" + ".java");

                    new AndroidMethods(DirPath +
                            "TestPrograms" + File.separator +
                            "com" + File.separator +
                            "advancedse" + File.separator + "project"
                            + File.separator,2);

//					File file = new File("./FiveMLOCStart.java");
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter writer = new BufferedWriter(fileWriter);

                    StringBuffer output = new StringBuffer();

                    output.append("package com.advancedse.project;\n\n");
//					output.append("public class FiveMLOCStart {\n");
                    //changedHere
                    output.append("import android.os.Bundle;\n" +
                            "import android.support.v7.app.AppCompatActivity;\nimport java.util.Random;\n\n");
                    output.append("public class " + ConfigurationXMLParser.getProperty("classNamePrefix") + "Start extends AppCompatActivity{\n");
                    for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                        output.append("private static int f" + k + ";\n");
                    }

                    output.append("\n\n");

                    output.append("public static void entryMethod(");
                    //int i0, int i1, int i2, int i3, int i4, int i5, int i6){\n");


                    output.append(formalParam + "){\n");


                    for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                        output.append("f" + k + " = " + "i" + k + ";\n");
                    }

                    //output.append("TStart_L"+(level-1)+"_0.entryMethod("+ argument +");\n}\n\n");
                    output.append("\n}\n\n");

                    //changedHere
                    output.append("@Override\nprotected void onCreate(Bundle savedInstance){\nsuper.onCreate(savedInstance);\n  entryMethod(");


                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < ProgGenUtil.maxNoOfParameters; i++) {
                        str.append("Integer.parseInt(\"\"+f" + i + "),");
                    }
                    String s = str.toString();
                    s = s.substring(0, str.length() - 1);
                    s += ");\n}";

                    output.append(s);


                    Random random = new Random(System.currentTimeMillis());
                    AndroidMethods androidMethods = new AndroidMethods(random);
                    output.append(androidMethods.generateOnResumeMethod());
                    // if (random.nextInt() % 2 == 0) {

                    //}

                    output.append("\n}");
                    String out = output.toString();
//					System.out.println("Writing the 'Start' class.");

                    writer.write(out);
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return;

            } else {

                int count = 0;
                int loop = (int) Math.ceil((double) target / 150);

                for (int i = 0; i < loop; i++) {
                    /*
                     * create 'loop' number of classes,where each calls 150 or
					 * less TStart_L(prevlevel)_X.entryMethod() methods; in
					 * total 'target' number of calls.
					 * 
					 * Name each class TStart_Llevel_X
					 */

                    try {

                        File file = new File(DirPath +
                                "TestPrograms" + File.separator +
                                "com" + File.separator +
                                "advancedse" + File.separator + "project"
                                + File.separator + "TStart_L" + level + "_" + i + ".java");

//						File file = new File("./TStart_L"+level+"_"+i+".java");
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter writer = new BufferedWriter(fileWriter);

                        StringBuffer output = new StringBuffer();

                        output.append("package com.advancedse.project;\n\n");
                        output.append("public class TStart_L" + level + "_" + i + "{\n");
                        for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                            output.append("private static int f" + k + ";\n");
                        }

                        output.append("\n\n");

                        output.append("public static void entryMethod(");
                        //int i0, int i1, int i2, int i3, int i4, int i5, int i6){\n");

                        output.append(formalParam + "){\n");

                        for (int k = 0; k < ProgGenUtil.maxNoOfParameters; k++) {
                            output.append("f" + k + " = " + "i" + k + ";\n");
                        }

                        for (int j = 0; j < methCallLimit && count < target; j++, count++) {
                            // Call TStart_L(prevlevel)_X.entryMethod()
                            output.append("TStart_L" + (level - 1) + "_" + count + ".entryMethod(" + argument + ");\n");
                        }

                        output.append("}\n}");


                        String out = output.toString();
//						System.out.println("Writing mid level classes.");

                        writer.write(out);
                        writer.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                createClass(level + 1, loop);

            }
        }
    }


}
