package pro.tariel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.inject.Named;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value = "auto")
public class AutoBean implements Serializable {
    private List<Car> list;
    private Car car;
    private String title = "Машинки";



    public AutoBean() {
        list = new ArrayList<>();
        init();

    }

    private void init() {
        car = new Car();
        car.setId("aa");
        car.setYear(1999);
        car.setBrand("Audi");
        car.setColor("Blue");
        list.add(car);

        car = new Car();
        car.setId("dd");
        car.setYear(2000);
        car.setBrand("Lada");
        car.setColor("Black");
        list.add(car);

        car = new Car();
        car.setId("cf");
        car.setYear(2001);
        car.setBrand("Ford");
        car.setColor("Red");
        list.add(car);

        car = new Car();
        car.setId("4e");
        car.setYear(2010);
        car.setBrand("Audi");
        car.setColor("Green");
        list.add(car);

        car = new Car();
        car.setId("u7");
        car.setYear(2005);
        car.setBrand("Audi");
        car.setColor("Red");
        list.add(car);

        car = new Car();
        car.setId("kk");
        car.setYear(1985);
        car.setBrand("ZAZ");
        car.setColor("Баклажан");
        list.add(car);

        car = new Car();
        car.setId("n5");
        car.setYear(2012);
        car.setBrand("Mercedes");
        car.setColor("White");
        list.add(car);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }
}



