package org.example.boj;
/*
Hello World!를 출력하시오.
 */
public class p2557 {
    public static void main(String[] args){
        Printer printer = new Printer();
        printer.print("Hello World!");
    }


}

class Printer {
    public void print(String content) {
        System.out.println(content);
    }
}

