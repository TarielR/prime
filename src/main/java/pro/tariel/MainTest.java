package pro.tariel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainTest {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Handler handler = new Handler();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("source.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        List<Car> list = handler.getList();
        for (Car car : list) {
            System.out.println(car);
        }
    }
}

class Handler extends DefaultHandler {
    private Map<String, String> data = new HashMap<>();
    private String id;
    private String element;
    private Car car;
    private List<Car> list = new ArrayList<>();


    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("auto")) {
            id = attributes.getValue(0);
            car = new Car();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = "";
        if (!list.contains(car)) {
            list.add(car);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.isEmpty() || id == null) {
            return;
        }


        car.setId(id);

        if (element.equals("brand")) {
            String str = new String(ch, start, length);
            car.setBrand(str);
        }

        if (element.equals("year")) {
            String str = new String(ch, start, length);
            car.setYear(Integer.parseInt(str));
        }

        if (element.equals("color")) {
            String str = new String(ch, start, length);
            car.setColor(str);
        }
    }


    public List getList() {
        return list;
    }
}