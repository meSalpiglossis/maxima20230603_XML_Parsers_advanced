import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXXMLParser {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();

            saxParser.parse("storage01.xml", saxHandler);
            Storage storage = saxHandler.getStorage();

            for (Article currentArticle : storage.articles) {
                System.out.println(currentArticle.getTitle());
                System.out.println(currentArticle.getContent());
                System.out.println("===================================");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
