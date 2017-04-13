package com.advancedse.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.Random;

public class RUGRATStart extends AppCompatActivity{
private static int f0;
private static int f1;
private static int f2;
private static int f3;
private static int f4;
private static int f5;
private static int f6;
private static int f7;
private static int f8;
private static int f9;
private static int f10;
private static int f11;
private static int f12;
private static int f13;
private static int f14;


public static void entryMethod(int i0,int i1,int i2,int i3,int i4,int i5,int i6,int i7,int i8,int i9,int i10,int i11,int i12,int i13,int i14){
f0 = i0;
f1 = i1;
f2 = i2;
f3 = i3;
f4 = i4;
f5 = i5;
f6 = i6;
f7 = i7;
f8 = i8;
f9 = i9;
f10 = i10;
f11 = i11;
f12 = i12;
f13 = i13;
f14 = i14;

}

@Override
protected void onCreate(Bundle savedInstance){
super.onCreate(savedInstance);
  entryMethod(Integer.parseInt(""+f0),Integer.parseInt(""+f1),Integer.parseInt(""+f2),Integer.parseInt(""+f3),Integer.parseInt(""+f4),Integer.parseInt(""+f5),Integer.parseInt(""+f6),Integer.parseInt(""+f7),Integer.parseInt(""+f8),Integer.parseInt(""+f9),Integer.parseInt(""+f10),Integer.parseInt(""+f11),Integer.parseInt(""+f12),Integer.parseInt(""+f13),Integer.parseInt(""+f14));
}@Override
public void onResume(){
super.onResume();
Random random = new Random();
if(random.nextInt()==random.nextInt()){System.out.println("In if statement");}else{System.out.println("In else statement");}for(int i=0;i<1;i++){
System.out.println("Random integer in for: 75");
System.out.println("Random integer in for: 91");
}int i1=0;while(i1<0){
System.out.println("Random integer in while: 72");
System.out.println("Random integer in while: 76");
i1++;}int s = random.nextInt(5);switch(s){case 0:System.out.println("In switch statement, case 0: "+(15+42));
break;
 case 1:System.out.println("In switch statement, case 1: "+(6-63));
break;
 case 2:System.out.println("In switch statement, case 2: "+(82*8));
break;
 case 3:System.out.println("In switch statement, case 3: "+(98/48));
break;
 case 4:System.out.println("In switch statement, case 4: "+(37%25));
break;
 default:System.out.println("In default case: "+(65+98));
break;
 }}

}