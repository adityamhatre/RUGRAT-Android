package edu.uta.cse.proggen.classLevelElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Aditya on 029, 29 Apr, 2017.
 */
public class XMLGenerator {
    //private String[] elements = {"Button", "TextView", "EditText", "LinearLayout"};
    private String[] dimensions = {"match_parent", "wrap_content"};
    private ArrayList<String> buttonIDTracker, textViewIDTracker, editTextIDTracker;

    private ArrayList<Mapper> elements;

    private String xml;
    private StringBuffer stringBuffer;

    private Random random;

    XMLGenerator(ArrayList<Mapper> elements) {
        this.elements = elements;

        stringBuffer = new StringBuffer();

        random = new Random(System.currentTimeMillis());

        buttonIDTracker = new ArrayList<>();
        textViewIDTracker = new ArrayList<>();
        editTextIDTracker = new ArrayList<>();

        buttonIDTracker.add("button0");
        textViewIDTracker.add("textView0");
        editTextIDTracker.add("editText0");

        generateXML();
    }

    private void generateXML() {
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
                        stringBuffer.append("<Button\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + buttonIDTracker.get(buttonIDTracker.size() - 1) + "\"\n" +
                                "        android:text=\"lol\" />");
                        buttonIDTracker.add("button" + buttonIDTracker.size());
                    }
                    break;
                case "textview":
                    for (int j = 0; j < elements.get(i).getNumberOfElements(); j++) {
                        stringBuffer.append("<TextView\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + textViewIDTracker.get(textViewIDTracker.size() - 1) + "\"\n" +
                                "        android:text=\"lol\" />");
                        textViewIDTracker.add("textView" + textViewIDTracker.size());
                    }
                    break;
                case "edittext":
                    for (int j = 0; j < elements.get(i).getNumberOfElements(); j++) {
                        stringBuffer.append("<EditText\n" +
                                "        android:layout_width=\"" + dimensions[random.nextInt(2)] + "\"\n" +
                                "        android:layout_height=\"wrap_content\"\n" +
                                "        android:id=\"@+id/" + editTextIDTracker.get(editTextIDTracker.size() - 1) + "\"\n" +
                                "        android:hint=\"lol\" />");
                        editTextIDTracker.add("editText" + editTextIDTracker.size());
                    }
                    break;
            }

        }
        stringBuffer.append("</LinearLayout>");
        stringBuffer.append("</ScrollView>");

        xml = stringBuffer.toString();

        System.out.println(xml);
    }

    public static void main(String[] args) {
        ArrayList<Mapper> mapper = new ArrayList<>();
        mapper.add(new Mapper("Button", 5));
        mapper.add(new Mapper("EditText", 12));
        mapper.add(new Mapper("TextView", 3));
        new XMLGenerator(mapper);
    }
}
