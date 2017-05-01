package edu.uta.cse.proggen.classLevelElements;

import edu.uta.cse.proggen.statements.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aditya on 008, 8 Apr, 2017.
 */
public class AndroidMethods {

    private Random random;

    public AndroidMethods(Random random) {
        this.random = random;
    }

    private File file;
    private BufferedWriter bufferedWriter;

    private int numberOfButtons, numberOfTextViews, numberOfEditTexts;

    private ArrayList<String> variables;

    AndroidMethods(String path, int numberOfButtons, int numberOfTextViews, int numberOfEditTexts, int currentFileIndex) {
        this.numberOfButtons = numberOfButtons;
        this.numberOfTextViews = numberOfTextViews;
        this.numberOfEditTexts = numberOfEditTexts;

        variables = new ArrayList<>();

        random = new Random(System.currentTimeMillis());
        try {

            file = new File(path + ("MainActivity" + (currentFileIndex + 1) + ".java"));
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String uiElements = generateUIElements();
            String onCreate = generateOnCreateMethod(currentFileIndex + 1);
            String onResume = generateOnResumeMethod();


            bufferedWriter.write("package com.advancedse.project;\n");
            bufferedWriter.write(generateImportStatements());
            bufferedWriter.write(generateClassName(currentFileIndex + 1));
            bufferedWriter.write(uiElements);
            bufferedWriter.write(onCreate);
            bufferedWriter.write(onResume);
            bufferedWriter.write(generateEndOfClass());
            if (bufferedWriter != null) {
                bufferedWriter.close();
                fileWriter.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String generateUIElements() {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < numberOfButtons; i++) {
            out.append("private Button button").append(i + 1).append(";\n");
        }
        for (int i = 0; i < numberOfTextViews; i++) {
            out.append("private TextView textView").append(i + 1).append(";\n");
        }
        for (int i = 0; i < numberOfEditTexts; i++) {
            out.append("private EditText editText").append(i + 1).append(";\n");
        }
        return out.toString();
    }

    private String generateEndOfClass() {
        return "}";
    }

    private String generateClassName(int i) {
        StringBuilder out = new StringBuilder("public class MainActivity" + i + " extends AppCompatActivity {\n");
        Set<String> uniqueVariables = new LinkedHashSet<>(variables);

        Iterator iterator = uniqueVariables.iterator();
        while (iterator.hasNext()) {
            out.append("int " + iterator.next() + ";\n");
        }
        return out.toString();
    }

    private String generateImportStatements() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("import android.os.Bundle;\n");
        stringBuffer.append("import android.support.v7.app.AppCompatActivity;\n");
        stringBuffer.append("import java.util.Random;\n");
        stringBuffer.append("import android.widget.Button;\n");
        stringBuffer.append("import android.widget.TextView;\n");
        stringBuffer.append("import android.widget.EditText;\n");
        stringBuffer.append("import android.view.View;\n");
        stringBuffer.append("import android.widget.Toast;\n");
        return stringBuffer.toString();
    }

    public String generateOnResumeMethod() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@Override\n");
        stringBuffer.append("public void onResume(){\nsuper.onResume();\n");
        stringBuffer.append("Random random = new Random();\n");

        if (random.nextBoolean()) stringBuffer.append(generateIFStatement());
        if (random.nextBoolean()) stringBuffer.append(generateIfElseStatement());
        if (random.nextBoolean()) stringBuffer.append(generateForLoop());
        if (random.nextBoolean()) stringBuffer.append(generateWhileLoop());
        if (random.nextBoolean()) stringBuffer.append(generateDoWhileLoop());
        if (random.nextBoolean()) stringBuffer.append(generateSwitchCase());

        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public String generateOnCreateMethod(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@Override\n");
        stringBuffer.append("public void onCreate(Bundle savedInstance){\nsuper.onCreate(savedInstance);\n");
        stringBuffer.append("setContentView(R.layout.layout_activity").append(i).append(");");
        for (int j = 0; j < numberOfButtons; j++) {
            stringBuffer.append("button").append(j + 1).append(" = (Button) findViewById(R.id.button").append(j + 1).append(");");
        }
        for (int j = 0; j < numberOfTextViews; j++) {
            stringBuffer.append("textView").append(j + 1).append(" = (TextView) findViewById(R.id.textView").append(j + 1).append(");");
        }
        for (int j = 0; j < numberOfEditTexts; j++) {
            stringBuffer.append("editText").append(j + 1).append(" = (EditText) findViewById(R.id.editText").append(j + 1).append(");");
        }
        for (int j = 0; j < numberOfButtons; j++) {
            stringBuffer.append("button" + (j + 1) + ".setOnClickListener(new View.OnClickListener() {\n" +
                    "            public void onClick(View v) {\n" +
                    "                Toast.makeText(MainActivity" + i + ".this, \"Button " + (j + 1) + " clicked\",Toast.LENGTH_SHORT).show();\n" +
                    "            }\n" +
                    "        });");
        }

        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String generateIFStatement() {
        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new IfElse(variables, false).generate();

    }

    public String generateIfElseStatement() {
        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new IfElse(variables).generate();
    }

    public String generateSwitchCase() {
        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new Switch(variables).generate();

    }

    public String generateForLoop() {
        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new ForLoop(variables).generate();

    }

    public String generateWhileLoop() {
        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new WhileLoop(variables).generate();
    }

    public String generateDoWhileLoop() {

        String randomVariable = "variable" + variables.size();
        variables.add(randomVariable);
        return new DoWhileLoop(variables).generate();
    }

    public static void main(String[] args) {
        //new AndroidMethods("C://Users//Aditya//Desktop//ADVSE//", 3);
        //new XMLGenerator("C://Users//Aditya//Desktop//ADVSE//", 3);
    }
}
