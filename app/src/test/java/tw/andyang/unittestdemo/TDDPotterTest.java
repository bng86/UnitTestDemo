package tw.andyang.unittestdemo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 哈利波特一到五冊熱潮正席捲全球，世界各地的孩子都為之瘋狂。
 * 出版社為了慶祝Agile Tour第一次在台灣舉辦，決定訂出極大的優惠，來回饋給為了小孩四處奔波買書的父母親們。
 * 定價的方式如下：
 * 1. 一到五集的哈利波特，每一本都是賣100元
 * 2. 如果你從這個系列買了兩本不同的書，則會有5%的折扣
 * 3. 如果你買了三本不同的書，則會有10%的折扣
 * 4. 如果是四本不同的書，則會有20%的折扣
 * 5. 如果你一次買了整套一到五集，恭喜你將享有25%的折扣
 * 6. 需要留意的是，如果你買了四本書，其中三本不同，第四本則是重複的，
 * 那麼那三本將享有10%的折扣，但重複的那一本，則仍須100元。
 * 你的任務是，設計一個哈利波特的購物車，能提供最便宜的價格給這些爸爸媽媽。
 */

public class TDDPotterTest {


    /**
     * Scenario1: 第一集買了一本，其他都沒買，價格應為100*1=100元
     * Given 第一集買了 1 本
     * And 第二集買了 0 本
     * And 第三集買了 0 本
     * And 第四集買了 0 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 100 元
     */

    @Test
    public void test_Scenario1() throws Exception {
        Cart cart = new Cart();
        ArrayList<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 100;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario2: 第一集買了一本，第二集也買了一本，價格應為100*2*0.95=190
     * Given 第一集買了 1 本
     * And 第二集買了 1 本
     * And 第三集買了 0 本
     * And 第四集買了 0 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 190 元
     */

    @Test
    public void test_Scenario2() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 190f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario3: 一二三集各買了一本，價格應為100*3*0.9=270
     * Given 第一集買了 1 本
     * And 第二集買了 1 本
     * And 第三集買了 1 本
     * And 第四集買了 0 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 270 元
     */

    @Test
    public void test_Scenario3() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
                add(new Book("Potter III"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 270f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario: 一二三四集各買了一本，價格應為100*4*0.8=320
     * Given 第一集買了 1 本
     * And 第二集買了 1 本
     * And 第三集買了 1 本
     * And 第四集買了 1 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 320 元
     */

    @Test
    public void test_Scenario4() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
                add(new Book("Potter III"));
                add(new Book("Potter VI"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 320f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario5: 一次買了整套，一二三四五集各買了一本，價格應為100*5*0.75=375
     * Given 第一集買了 1 本
     * And 第二集買了 1 本
     * And 第三集買了 1 本
     * And 第四集買了 1 本
     * And 第五集買了 1 本
     * When 結帳
     * Then 價格應為 375 元
     */

    @Test
    public void test_Scenario5() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
                add(new Book("Potter III"));
                add(new Book("Potter VI"));
                add(new Book("Potter V"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 375f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario6: 一二集各買了一本，第三集買了兩本，價格應為100*3*0.9 + 100 = 370
     * Given 第一集買了 1 本
     * And 第二集買了 1 本
     * And 第三集買了 2 本
     * And 第四集買了 0 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 370 元
     */

    @Test
    public void test_Scenario6() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
                add(new Book("Potter III"));
                add(new Book("Potter III"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 370f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    /**
     * Scenario7: 第一集買了一本，第二三集各買了兩本，價格應為100*3*0.9 + 100*2*0.95 = 460
     * Given 第一集買了 1 本
     * And 第二集買了 2 本
     * And 第三集買了 2 本
     * And 第四集買了 0 本
     * And 第五集買了 0 本
     * When 結帳
     * Then 價格應為 460 元
     */

    @Test
    public void test_Scenario7() throws Exception {
        Cart cart = new Cart();
        List<Book> books = new ArrayList<Book>() {
            {
                add(new Book("Potter I"));
                add(new Book("Potter II"));
                add(new Book("Potter II"));
                add(new Book("Potter III"));
                add(new Book("Potter III"));
            }
        };
        cart.setBooks(books);
        float actual = cart.getPrice();
        float expected = 460f;
        Assert.assertEquals(expected, actual, 0.0f);
    }

    private class Cart {

        private List<Book> books;

        public float getPrice() {

            float amount = 0.0f;

            Set<Book> bookSet = new HashSet<>();
            while (books.size() != 0) {
                bookSet.addAll(books);
                amount += bookSet.size() * 100 * getDiscount(bookSet.size());

                for (Book book : bookSet){
                    books.remove(book);
                }

                bookSet.clear();
            }

            return amount;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }

        private float getDiscount(int size) {

            switch (size) {
                case 2:
                    return 0.95f;
                case 3:
                    return 0.9f;
                case 4:
                    return 0.8f;
                case 5:
                    return 0.75f;
                default:
                    return 1.0f;
            }
        }
    }


    private class Book {

        private String name;

        public Book(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Book book = (Book) o;

            return name != null ? name.equals(book.name) : book.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}