package com.advancedse.project;


public class RUGRAT0 extends RUGRAT2 implements RUGRATInterface1 {


public int RUGRATInterface1Method0(int var0, int var1, int var2, int var3){
 if( ((var3*var0)!=(var3/(int)(6)))){
if( ((var1*var3)!=(var0/(int)(2)))){
var0 = (int)(7);
}
}
switch((var2+(int)(45))){
case 0:
var2 = (int)((var1-var2)+(var1+(int)(40)));
 break;
case 1:
RUGRAT0method2(var2,var2,var1,var1); break;
case 2:
System.out.println("RUGRAT0 - RUGRATInterface1Method0- LineInMethod: 12");
 break;
case 3:
System.out.println("RUGRAT0 - RUGRATInterface1Method0- LineInMethod: 15");
 break;
case 4:
System.out.println("RUGRAT0 - RUGRATInterface1Method0- LineInMethod: 18");
 break;
case 5:
var2 = (int)(((var0+var1)-(var1*var0))/(int)(20));
 break;
case 6:
System.out.println("RUGRAT0 - RUGRATInterface1Method0- LineInMethod: 27");
 break;
default :
System.out.println("RUGRAT0 - RUGRATInterface1Method0- LineInMethod: 33");
}
return (int)var3;

}

public int RUGRAT0method0(int var0, int var1, int var2, int var3, int var4){
 if(((var0%(int)(23))>=(var1-var0))){
System.out.println("RUGRAT0 - RUGRAT0method0- LineInMethod: 4");
}
else{
 RUGRAT0method2(var1,var4,var1,var2);}
for(int i = 0; i < 3; i++){
 var1 = (int)((var0-var1)+(var3*(int)(23)));
}
return (int)var2;

}

public int RUGRAT0method1(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9){
 if( ((var7+var8)>=(var8/(int)(31)))){
if( ((var7*var0)==(var5%(int)(46)))){
if( ((((var4%(int)(14))-(var7-(int)(2)))/(int)(49))<((var7+(int)(14))+(var7%(int)(3))))){
System.out.println("RUGRAT0 - RUGRAT0method1- LineInMethod: 6");
}
}
}
for(int i = 0; i < 3; i++){
 System.out.println("RUGRAT0 - RUGRAT0method1- LineInMethod: 11");
}
return (int)var3;

}

public static int RUGRAT0method2(int var0, int var1, int var2, int var3){
 switch((var3-(int)(10))){
case 0:
var3 = (int)((var2+var3)+(var3*var2));
 break;
case 1:
System.out.println("RUGRAT0 - RUGRAT0method2- LineInMethod: 5");
 break;
default :
var2 = (int)(46);
}
return (int)var1;

}

public static int RUGRAT2method2(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12){
 if( ((var9+var2)<=(var0-var6))){
var12 = (int)(48);
}
if( ((var5+var8)==(var9/(int)(3)))){
if( ((var1-var6)>(var6-var8))){
System.out.println("RUGRAT0 - RUGRAT2method2- LineInMethod: 6");
}
}
return (int)var11;

}

public static int RUGRAT2method1(int var0, int var1, int var2, int var3, int var4, int var5, int var6){
 for(int i = 0; i < 2; i++){
 if( ((var2*var4)==(var6+var2))){
if( ((var3%(int)(32))>=(var3*var2))){
if( ((var1*var6)>((var2+var5)-(((var0+var3)%(int)(46))%(int)(9))))){
System.out.println("RUGRAT0 - RUGRAT2method1- LineInMethod: 8");
}
}
}
}
return (int)var5;

}


public static void singleEntry(int i0,int i1,int i2,int i3,int i4,int i5,int i6,int i7,int i8,int i9,int i10,int i11,int i12,int i13,int i14){
RUGRAT0 obj = new RUGRAT0();
obj.RUGRATInterface1Method0(i2,i7,i14,i8);
obj.RUGRAT0method0(i4,i13,i1,i11,i5);
obj.RUGRAT0method1(i10,i8,i12,i11,i4,i9,i1,i13,i5,i7);
RUGRAT0method2(i4,i11,i12,i0);
RUGRAT2method2(i7,i3,i14,i0,i9,i1,i6,i2,i8,i12,i11,i5,i13);
RUGRAT2method1(i7,i13,i3,i2,i8,i9,i4);
}

}