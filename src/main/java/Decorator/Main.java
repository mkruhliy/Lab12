package Decorator;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        document = new TimedDocument(document);
        System.out.println(document.parse());
    }
}