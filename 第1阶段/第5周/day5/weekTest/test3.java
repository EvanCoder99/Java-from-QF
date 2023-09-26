package week5.day5.weekTest;

import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{
    private String name;
    private Double price;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book [" +
                "name='" + name + '\'' +
                ", price=" + price +
                ']';
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public int compareTo(Book o) {
        if (this.price.equals(o.price))
            return o.name.compareTo(this.name);
        return o.price.compareTo(this.price);
    }
}
public class test3 {
    public static void main(String[] args) {
        Set<Book> set = new TreeSet();
        set.add(new Book("AAA",199.0));
        set.add(new Book("BBB",299.0));
        set.add(new Book("CCC",399.0));
        set.add(new Book("AAD",199.0));

        for (Book book : set) {
            System.out.println(book);
        }
    }
}
