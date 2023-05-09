import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {
    @Test
    public void Test1 (){
        System.out.println();
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),new Book(100, "5678"),
                new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};

        float total_test = 20 + 95 + 20 + 25;
        assertEquals(total_test,Visitor.calculatePrice(items), 0.001);
        System.out.println("Total Cost = " + total_test + '\n');

    }
    @Test
    public void Test2(){
        System.out.println();
        ItemElement[] items = new ItemElement[]{new Book(120, "1234"),new Book(200, "5678"),
                new Fruit(15, 10, "Pomelo"), new Fruit(55, 1, "Dragon Fruit")};

        float total_test = 120-5+200-5+15*10+55*1;

        assertEquals(total_test,Visitor.calculatePrice(items), 0.001);
        System.out.println("Total Cost = " + total_test + '\n');

    }
    @Test
    public void Test3(){
        System.out.println();
        ItemElement[] itemsss = new ItemElement[]{};

//        int total_test = Visitor.calculatePrice(new ItemElement[]{new Book(20, "1234"),new Book(100, "5678"),
//                new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")});

        float total_test = 0;

        System.out.println("Total Cost = " + Visitor.calculatePrice(itemsss) + '\n');
        assertEquals(total_test,Visitor.calculatePrice(itemsss), 0.001);
    }
    @Test
    public void Test4(){
        System.out.println();
        ItemElement[] itemsss = new ItemElement[]{new Book(-20, "1234"),new Book(100, "5678"),
                new Fruit(10, -2, "Banana"), new Fruit(-5, 5, "Apple")};


        float total_test = 95;

        assertEquals(total_test,Visitor.calculatePrice(itemsss), 0.001);
        System.out.println("Total Cost = " + total_test + '\n');

    }

    @Test
    public void Test5(){
        System.out.println();
        ItemElement[] itemsss = new ItemElement[]{new Book(-20, "1234"),new Book(0, "5678"),
                new Fruit(10, -2, "Banana"), new Fruit(-5, 5, "Apple")};

        float total_test = 0;

        assertEquals(total_test,Visitor.calculatePrice(itemsss), 0.001);
        System.out.println("Total Cost = " + total_test + '\n');
    }
    @Test
    public void Test6(){
        System.out.println();
        ItemElement[] itemsss = new ItemElement[]{new Book(51, "1234"),new Book(0, "5678"),
                new Fruit(10, 0, "Banana"), new Fruit(5, 5, "Apple")};

        float total_test = 51 - 5 + 10 * 0 + 0 + 5 * 5;

        assertEquals(total_test,Visitor.calculatePrice(itemsss), 0.001);
        System.out.println("Total Cost = " + total_test + '\n');
    }
}
