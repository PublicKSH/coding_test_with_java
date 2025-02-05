class Person {
    private int age;
    public int getAge() { return age; }
}

public class Main {
    public static void main(String[] args) {
        Person[] pArr = new Person[2];
        System.out.println(pArr[0].getAge());
    }
}