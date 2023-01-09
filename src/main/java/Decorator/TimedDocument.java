package Decorator;

public class TimedDocument implements Document {
    Document document;
    public TimedDocument(Document document) {
        this.document = document;
    }

    public long measureTime(){
        long start = System.currentTimeMillis();
        this.parse();
        return System.currentTimeMillis() - start;
    }


    @Override
    public String parse() {
        return document.parse();
    }
}