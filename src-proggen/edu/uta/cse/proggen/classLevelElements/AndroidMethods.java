package edu.uta.cse.proggen.classLevelElements;

import edu.uta.cse.proggen.statements.ForLoop;

import java.util.Random;

/**
 * Created by Aditya on 008, 8 Apr, 2017.
 */
public class AndroidMethods {

    Random random;

    public AndroidMethods(Random random) {
        this.random = random;
    }

    public String generateOnResumeMethod() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@Override\n");
        stringBuffer.append("public void onResume(){\nsuper.onResume();\n");

        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateIFStatement());
        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateIfElseStatement());
        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateForLoop());
        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateWhileLoop());
        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateDoWhileLoop());
        if (random.nextInt() > random.nextInt()) stringBuffer.append(generateSwitchCase());

        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }


    public String generateIFStatement() {
        StringBuffer stringBuffer = new StringBuffer();

        int a = random.nextInt();
        int b = random.nextInt();

        int control = (int) (Math.random() * 5);
        switch (control % 4) {
            case 0:
                stringBuffer.append("if(" + a + ">" + b + "){");
                break;
            case 1:
                stringBuffer.append("if(" + a + "<" + b + "){");
                break;
            case 2:
                stringBuffer.append("if(" + a + "==" + b + "){");
                break;
            case 3:
                stringBuffer.append("if(" + a + "!=" + b + "){");
                break;
            default:
                stringBuffer.append("if(" + a + ">" + b + "){");
                break;
        }
        stringBuffer.append("System.out.println(\"In if statement\");}");
        return stringBuffer.toString();


    }

    public String generateIfElseStatement() {
        StringBuffer stringBuffer = new StringBuffer();
        int a = random.nextInt();
        int b = random.nextInt();

        int control = (int) (Math.random() * 5);
        switch (control % 4) {
            case 0:
                stringBuffer.append("if(" + a + ">" + b + "){");
                break;
            case 1:
                stringBuffer.append("if(" + a + "<" + b + "){");
                break;
            case 2:
                stringBuffer.append("if(" + a + "==" + b + "){");
                break;
            case 3:
                stringBuffer.append("if(" + a + "!=" + b + "){");
                break;
            default:
                stringBuffer.append("if(" + a + ">" + b + "){");
                break;
        }
        stringBuffer.append("System.out.println(\"In if statement\");}");
        stringBuffer.append("else{System.out.println(\"In else statement\");}");
        return stringBuffer.toString();
    }

    public String generateSwitchCase() {
        StringBuffer stringBuffer = new StringBuffer();
        char variable = (char) (97 + random.nextInt(26));
        int value = random.nextInt(5);

        stringBuffer.append("int " + variable + " = " + value + ";");
        stringBuffer.append("switch(" + variable + "){");
        stringBuffer.append("case 0:System.out.println(\"" + random.nextInt(100) + "+" + random.nextInt(100) + "\");\nbreak;\n ");
        stringBuffer.append("case 1:System.out.println(\"" + random.nextInt(100) + "-" + random.nextInt(100) + "\");\nbreak;\n ");
        stringBuffer.append("case 2:System.out.println(\"" + random.nextInt(100) + "*" + random.nextInt(100) + "\");\nbreak;\n ");
        stringBuffer.append("case 3:System.out.println(\"" + random.nextInt(100) + "/" + random.nextInt(100) + "\");\nbreak;\n ");
        stringBuffer.append("case 4:System.out.println(\"" + random.nextInt(100) + "%" + random.nextInt(100) + "\");\nbreak;\n ");
        stringBuffer.append("default:System.out.println(\"" + random.nextInt(100) + "+" + random.nextInt(100) + "\");\nbreak;\n }");
        return stringBuffer.toString();
    }

    public String generateForLoop() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("for(int i=0;i<" + ForLoop.positiveInteger() + ";i++){\n");
        for (int i = 0; i < 2; i++) {
            stringBuffer.append("System.out.println(\"Random integer: " + random.nextInt(100) + "\");\n");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String generateWhileLoop() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("int i1=0;");
        stringBuffer.append("while(i1<" + ForLoop.positiveInteger() + "){\n");
        for (int i = 0; i < 2; i++) {
            stringBuffer.append("System.out.println(\"Random integer: " + random.nextInt(100) + "\");\n");
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
            stringBuffer.append("System.out.println(\"Random integer: " + random.nextInt(100) + "\");\n");
        }
        stringBuffer.append("i2++;");
        stringBuffer.append("}while(i2<" + ForLoop.positiveInteger() + ");\n");
        return stringBuffer.toString();
    }


}
