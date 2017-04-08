package com.advancedse.project;


public class RUGRAT1 implements RUGRATInterface2 {


public int RUGRATInterface2Method0(int var0, int var1, int var2, int var3){
 switch((var1+var0)){
case 0:
var2 = (int)((((var0+var1)+(var2-(int)(40)))+(var2-var3))/(int)(1));
 break;
case 1:
System.out.println("RUGRAT1 - RUGRATInterface2Method0- LineInMethod: 5");
 break;
case 2:
System.out.println("RUGRAT1 - RUGRATInterface2Method0- LineInMethod: 11");
 break;
case 3:
System.out.println("RUGRAT1 - RUGRATInterface2Method0- LineInMethod: 14");
 break;
default :
System.out.println("RUGRAT1 - RUGRATInterface2Method0- LineInMethod: 21");
}
return (int)var0;

}

public static int RUGRAT1method0(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11){
 switch(((var1-var7)+(var11+var0))){
case 0:
RUGRAT1method3(var9,var7,var0,var2,var2); break;
case 1:
var10 = (int)(var8-var4);
 break;
case 2:
System.out.println("RUGRAT1 - RUGRAT1method0- LineInMethod: 8");
 break;
case 3:
RUGRAT1method3(var9,var10,var8,var3,var1); break;
case 4:
var9 = (int)((var8-var5)*(var6%(int)(46)));
 break;
case 5:
System.out.println("RUGRAT1 - RUGRAT1method0- LineInMethod: 17");
 break;
case 6:
var2 = (int)((var0/(int)(49))%(int)(23));
 break;
default :
System.out.println("RUGRAT1 - RUGRAT1method0- LineInMethod: 24");
}
return (int)var5;

}

public int RUGRAT1method1(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12){
 switch(((var10+(int)(3))%(int)(45))){
case 0:
System.out.println("RUGRAT1 - RUGRAT1method1- LineInMethod: 2");
 break;
case 1:
System.out.println("RUGRAT1 - RUGRAT1method1- LineInMethod: 8");
 break;
default :
System.out.println("RUGRAT1 - RUGRAT1method1- LineInMethod: 11");
}
return (int)var6;

}

public int RUGRAT1method2(int var0, int var1, int var2, int var3, int var4){
 if(((var1*var0)<=((var4+var0)-((var1/(int)(39))+(var2/(int)(37)))))){
var2 = (int)((var3*var2)%(int)(1));
}
else{
 System.out.println("RUGRAT1 - RUGRAT1method2- LineInMethod: 5");
}
switch((var1-(int)(19))){
case 0:
var4 = (int)((var4+var3)/(int)(7));
 break;
case 1:
System.out.println("RUGRAT1 - RUGRAT1method2- LineInMethod: 12");
 break;
case 2:
var2 = (int)(38);
 break;
case 3:
var1 = (int)((var2/(int)(26))+(var3+(int)(46)));
 break;
case 4:
System.out.println("RUGRAT1 - RUGRAT1method2- LineInMethod: 22");
 break;
case 5:
var2 = (int)((((var0+var4)%(int)(38))%(int)(18))+(var1-var3));
 break;
case 6:
System.out.println("RUGRAT1 - RUGRAT1method2- LineInMethod: 28");
 break;
default :
System.out.println("RUGRAT1 - RUGRAT1method2- LineInMethod: 32");
}
return (int)var0;

}

public static int RUGRAT1method3(int var0, int var1, int var2, int var3, int var4){
 if( ((var2+var3)==(var2*(int)(2)))){
System.out.println("RUGRAT1 - RUGRAT1method3- LineInMethod: 2");
}
for(int i = 0; i < 2; i++){
 System.out.println("RUGRAT1 - RUGRAT1method3- LineInMethod: 9");
}
return (int)var4;

}

public int RUGRAT1method4(int var0, int var1, int var2, int var3, int var4, int var5){
 for(int i = 0; i < 1; i++){
 var2 = (int)((var5+var3)*(var5*var1));
}
if( ((var3*var0)>=(var0*var3))){
if( (((var0/(int)(3))<(var3%(int)(37)))&&((var4+var5)<(var0*var2)))){
var4 = (int)((var4+var5)+(var4+var0));
}
}
if( ((var0-var3)<((var4-var3)+((var4-var5)*(((var1+var0)+(var0+var2))+(var4-(int)(38))))))){
if( ((((var2*var0)+(var1+var0))<=(var0-var1))&&(((var1%(int)(14))*(var1+var2))>(var2-var5)))){
System.out.println("RUGRAT1 - RUGRAT1method4- LineInMethod: 12");
}
}
return (int)var4;

}


public static void singleEntry(int i0,int i1,int i2,int i3,int i4,int i5,int i6,int i7,int i8,int i9,int i10,int i11,int i12,int i13,int i14){
RUGRAT1 obj = new RUGRAT1();
obj.RUGRATInterface2Method0(i0,i1,i3,i10);
RUGRAT1method0(i8,i9,i4,i3,i11,i1,i0,i7,i2,i12,i5,i6);
obj.RUGRAT1method1(i5,i14,i9,i8,i13,i0,i7,i6,i3,i1,i4,i12,i10);
obj.RUGRAT1method2(i10,i5,i8,i3,i7);
RUGRAT1method3(i1,i12,i14,i13,i4);
obj.RUGRAT1method4(i4,i8,i14,i6,i11,i7);
}

}