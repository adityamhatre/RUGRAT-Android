package edu.uta.cse.proggen.classLevelElements;

import edu.uta.cse.proggen.statements.ForLoop;
import edu.uta.cse.proggen.statements.IfElse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Aditya on 008, 8 Apr, 2017.
 */
public class AndroidMethods {

    Random random;

    public AndroidMethods(Random random) {
        this.random = random;
    }

    File file;
    BufferedWriter bufferedWriter;

    int numberOfButtons, numberOfTextViews, numberOfEditTexts;

    public AndroidMethods(String path, int numberOfFiles) {
        random = new Random(System.currentTimeMillis());
        try {

            for (int i = 0; i < numberOfFiles; i++) {
                file = new File(path + ("activity" + (i + 1) + ".java"));
                FileWriter fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(generateImportStatements());
                bufferedWriter.write(generateClassName(i + 1));
                bufferedWriter.write(generateOnCreateMethod(i + 1));
                bufferedWriter.write(generateOnResumeMethod());
                bufferedWriter.write(generateEndOfClass());
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    fileWriter.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public AndroidMethods(String path, int numberOfButtons, int numberOfTextViews, int numberOfEditTexts, int currentFileIndex) {
        this.numberOfButtons = numberOfButtons;
        this.numberOfTextViews = numberOfTextViews;
        this.numberOfEditTexts = numberOfEditTexts;


        random = new Random(System.currentTimeMillis());
        try {

            file = new File(path + ("MainActivity" + (currentFileIndex + 1) + ".java"));
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("package com.thelegacycoder.advsetest;\n");
            bufferedWriter.write(generateImportStatements());
            bufferedWriter.write(generateClassName(currentFileIndex + 1));
            bufferedWriter.write(generateUIElements());
            bufferedWriter.write(generateOnCreateMethod(currentFileIndex + 1));
            bufferedWriter.write(generateOnResumeMethod());
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
        return "public class MainActivity" + i + " extends AppCompatActivity {\n";
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

        //if (random.nextBoolean() ? random.nextInt() > random.nextInt() : random.nextInt() < random.nextInt())

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
        StringBuffer stringBuffer = new StringBuffer();

        int a = random.nextInt();
        int b = random.nextInt();

        //int control = (int) (Math.random() * 5);
        int control = random.nextInt(5);


        switch (control % 4) {
            case 0:
                stringBuffer.append("if(random.nextInt()>random.nextInt()){");
                break;
            case 1:
                stringBuffer.append("if(random.nextInt()<random.nextInt()){");
                break;
            case 2:
                stringBuffer.append("if(random.nextInt()==random.nextInt()){");
                break;
            case 3:
                stringBuffer.append("if(random.nextInt()!=random.nextInt()){");
                break;
            default:
                stringBuffer.append("if(random.nextInt()>random.nextInt()){");
                break;
        }
        stringBuffer.append("System.out.println(\"In if statement\");}");
        return stringBuffer.toString();


    }


    public String generateIfElseStatement() {
        StringBuffer stringBuffer = new StringBuffer();
        int a = random.nextInt();
        int b = random.nextInt();

        int control = random.nextInt(5);
        switch (control % 4) {
            case 0:
                stringBuffer.append("if(random.nextInt()>random.nextInt()){");
                break;
            case 1:
                stringBuffer.append("if(random.nextInt()<random.nextInt()){");
                break;
            case 2:
                stringBuffer.append("if(random.nextInt()==random.nextInt()){");
                break;
            case 3:
                stringBuffer.append("if(random.nextInt()!=random.nextInt()){");
                break;
            default:
                stringBuffer.append("if(random.nextInt()>random.nextInt()){");
                break;
        }
        stringBuffer.append("System.out.println(\"In if statement\");}");
        stringBuffer.append("else{System.out.println(\"In else statement\");}");
        return stringBuffer.toString();
    }


    public String generateSwitchCase() {
        StringBuffer stringBuffer = new StringBuffer();
        char variable = (char) (97 + random.nextInt(26));
        //int value = random.nextInt(5);

        stringBuffer.append("int " + variable + " = random.nextInt(5);");
        stringBuffer.append("switch(" + variable + "){");

        //Statically appending cases...Dynamic appending would be done in next iteration depending on
        //the value of "value". Therefore each case of the variable would declared.

        stringBuffer.append("case 0:System.out.println(\"In switch statement, case 0: \"+(" + random.nextInt(100) + "+" + random.nextInt(100) + "));\nbreak;\n ");
        stringBuffer.append("case 1:System.out.println(\"In switch statement, case 1: \"+(" + random.nextInt(100) + "-" + random.nextInt(100) + "));\nbreak;\n ");
        stringBuffer.append("case 2:System.out.println(\"In switch statement, case 2: \"+(" + random.nextInt(100) + "*" + random.nextInt(100) + "));\nbreak;\n ");
        stringBuffer.append("case 3:System.out.println(\"In switch statement, case 3: \"+(" + random.nextInt(100) + "/" + random.nextInt(100) + "));\nbreak;\n ");
        stringBuffer.append("case 4:System.out.println(\"In switch statement, case 4: \"+(" + random.nextInt(100) + "%" + random.nextInt(100) + "));\nbreak;\n ");
        stringBuffer.append("default:System.out.println(\"In default case: \"+(" + random.nextInt(100) + "+" + random.nextInt(100) + "));\nbreak;\n }");
        return stringBuffer.toString();
    }

    public String generateForLoop() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("for(int i=0;i<" + ForLoop.positiveInteger() + ";i++){\n");
        for (int i = 0; i < 2; i++) {
            stringBuffer.append("System.out.println(\"Random integer in for: " + random.nextInt(100) + "\");\n");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String generateWhileLoop() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("int i1=0;");
        stringBuffer.append("while(i1<" + ForLoop.positiveInteger() + "){\n");
        for (int i = 0; i < 2; i++) {
            stringBuffer.append("System.out.println(\"Random integer in while: " + random.nextInt(100) + "\");\n");
        }
        stringBuffer.append("i1++;");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String generateDoWhileLoop() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("int i2=0;\n");
        stringBuffer.append("do{\n");
        for (int i = 0; i < 2; i++) {
            stringBuffer.append("System.out.println(\"Random integer in do while: " + random.nextInt(100) + "\");\n");
        }
        stringBuffer.append("i2++;");
        stringBuffer.append("}while(i2<" + ForLoop.positiveInteger() + ");\n");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        //new AndroidMethods("C://Users//Aditya//Desktop//ADVSE//", 3);
        //new XMLGenerator("C://Users//Aditya//Desktop//ADVSE//", 3);
    }
}
