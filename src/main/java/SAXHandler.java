import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private static final String ARTICLES = "articles";
    private static final String ARTICLE = "article";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";

    private Storage storage;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        storage = new Storage();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case ARTICLES:
                storage.articles = new ArrayList<>();
                break;
            case ARTICLE:
                storage.articles.add(new Article());
                break;
            case TITLE, CONTENT:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case TITLE:
                latestArticle().setTitle(elementValue.toString());
                break;
            case CONTENT:
                latestArticle().setContent(elementValue.toString());
                break;
        }
    }

    private Article latestArticle() {
        return storage.articles.get(storage.articles.size() - 1);
    }

    public Storage getStorage() {
        return storage;
    }
}
