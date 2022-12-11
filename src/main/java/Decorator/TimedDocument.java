package Decorator;

public class TimedDocument implements Document{
    private SmartDocument document;
    public TimedDocument(Document document) {
        this.document = (SmartDocument) document;
    }

    @Override
    public String parse() {
        System.out.println("ttttiiimmmeee");
        return "ttttiiimmmeee\n\n"+document.parse()+"\n\nooovvvveeeerrrr";

    }
}
