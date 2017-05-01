package edu.uta.cse.proggen.classLevelElements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Aditya on 029, 29 Apr, 2017.
 */
public class XMLGenerator {
    //private String[] elements = {"Button", "TextView", "EditText", "LinearLayout"};
    private String[] dimensions = {"match_parent", "wrap_content"};
    private ArrayList<String> buttonIDTracker, textViewIDTracker, editTextIDTracker;

    private ArrayList<String> xmlElements;

    private ArrayList<UIElement> elements;

    private String xml;
    private StringBuffer stringBuffer;

    private Random random;


    public XMLGenerator(String path, int numberOfFiles) {
        File file;
        BufferedWriter bufferedWriter;
        elements = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        new ManifestGenerator(path, numberOfFiles);
        try {
            for (int i = 0; i < numberOfFiles; i++) {
                elements.clear();
                elements.add(new UIElement("Button", random.nextInt(5)));
                elements.add(new UIElement("EditText", random.nextInt(5)));
                elements.add(new UIElement("TextView", random.nextInt(5)));
                new AndroidMethods(path, elements.get(0).getNumberOfElements(), elements.get(2).getNumberOfElements(), elements.get(1).getNumberOfElements(), i);

                file = new File(path + ("layout_activity" + (i + 1) + ".xml"));
                FileWriter fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(generateXML());
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    fileWriter.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //generateXML();
    }

    private String generateXML() {
        stringBuffer = new StringBuffer();

        random = new Random(System.currentTimeMillis());

        xmlElements = new ArrayList<>();
        buttonIDTracker = new ArrayList<>();
        textViewIDTracker = new ArrayList<>();
        editTextIDTracker = new ArrayList<>();

        buttonIDTracker.add("button1");
        textViewIDTracker.add("textView1");
        editTextIDTracker.add("editText1");
        stringBuffer.append("<ScrollView xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "    <LinearLayout android:orientation=\"vertical\"" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\">\n");
        for (int i = 0; i < elements.size(); i++) {
            switch (elements.get(i).getElement().toLowerCase()) {
                case "button":
                    for (int j = 0; j < elements.get(i).getNumberOfElements(); j++) {
                        xmlElements.add("<Button\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + buttonIDTracker.get(buttonIDTracker.size() - 1) + "\"\n" +
                                "        android:text=\"lol\" />");
                        buttonIDTracker.add("button" + (buttonIDTracker.size() + 1));
                    }
                    break;
                case "textview":
                    for (int j = 0; j < elements.get(i).getNumberOfElements(); j++) {
                        xmlElements.add("<TextView\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + textViewIDTracker.get(textViewIDTracker.size() - 1) + "\"\n" +
                                "        android:text=\"lol\" />");
                        textViewIDTracker.add("textView" + (textViewIDTracker.size() + 1));
                    }
                    break;
                case "edittext":
                    for (int j = 0; j < elements.get(i).getNumberOfElements(); j++) {
                        xmlElements.add("<EditText\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + editTextIDTracker.get(editTextIDTracker.size() - 1) + "\"\n" +
                                "        android:hint=\"lol\" />");
                        editTextIDTracker.add("editText" + (editTextIDTracker.size() + 1));
                    }
                    break;
            }

        }

        Collections.shuffle(xmlElements);
        for (String xmlElement : xmlElements) {
            stringBuffer.append(xmlElement);
        }
        stringBuffer.append("</LinearLayout>");
        stringBuffer.append("</ScrollView>");

        xml = stringBuffer.toString();
       /* File file = new File(DirPath +
                "TestPrograms" + File.separator +
                "com" + File.separator +
                "advancedse" + File.separator + "project"
                + File.separator + "layout_main.xml");*/
        System.out.println(xml);
        return xml;
    }

    public static void main(String[] args) {
        int numberOfActivities = 3;
        new XMLGenerator("C://Users//Aditya//Desktop//ADVSE//", numberOfActivities);
        new ManifestGenerator("C://Users//Aditya//Desktop//ADVSE//", numberOfActivities);
    }
}
