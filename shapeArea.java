import java.util.Scanner;
abstract class shape{
int a,b;
abstract void printArea();
}
class rectangle extends shape{
rectangle(int x,int y){
a=x;
b=y;
}
void printArea(){
System.out.println("Area of the rectangle:"+(a+b));
}}
class triangle extends shape{
triangle(int x,int y){
a=x;
b=y;
}
void printArea(){
System.out.println("Area of the triangle:"+(0.5*a*b));
}}
class circle extends shape{
circle(int r){
a=r;
}
void printArea(){
System.out.println("Area of the circle:"+(3.14*a*a));
}}
public class shapeArea{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the length and breadth of the rectangle:");
int l=sc.nextInt();
int b=sc.nextInt();
shape rect=new rectangle(l,b);
System.out.println("Enter the base and height of the triangle:");
int base=sc.nextInt();
int h=sc.nextInt();
shape tri=new triangle(base,h);
System.out.println("Enter the radius of the circle:");
int r=sc.nextInt();
shape cir=new circle(r);
rect.printArea();
tri.printArea();
cir.printArea();
sc.close();
}}
