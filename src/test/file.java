package test;

import b.fileB;

class C {
    public int publicSameClass = 1;
}

class D extends fileB {
    public int publicSameClass2 = 876;
}

public class file {
    private final static int privateInt = 2;

    public static void main(String[] args) {


        A obj = new A();
        b.fileB obj2 = new b.fileB();
        C obj1 = new C();
        D obj4 = new D();


        //Public
        // Can be Accessed From anyWhere
        System.out.println("Can be Accessed From AnyWhere" + obj.publicAnywhere); // Public class Accessed from another package
        System.out.println("Can be Accessed From AnyWhere" + obj1.publicSameClass); // Public class Accessed from Same Package Same Class
        System.out.println("Can be Accessed From AnyWhere" + obj2.publicOtherPackage); // Public class Accessed from Other Package

        //Private
        //Can be Accessed only With the same Class
        System.out.println("Can be Accessed only within Same Class" + privateInt); // Private class Accessed from Same Package Same Class

        //Default (Package -> Private)
        //Can be Accessed within the Same Package
        System.out.println("Can be Accessed only within Same Class" + privateInt); // Same Class
        System.out.println("Can be Accessed only within Same Class" + obj.publicAnywhere); // Same Class

        //protected
        //Can be Accessed within the Same package or Other Package that extends that class
        System.out.println("Can be Accessed only within Same Class" + obj4.publicSameClass2);
        System.out.println("Can be Accessed only within Same Class" + obj2.publicOtherPackage); // Different Class// Different Class
    }
}
