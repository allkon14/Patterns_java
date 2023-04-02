import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// RectInterface.java
interface RectInterface {
    void aboutMe();
    double calculateArea();
}


// Rectangle.java
class Rectangle implements RectInterface {
    double length;
    public double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public void aboutMe() {
        System.out.println("Shape type: Rectangle.");
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
}


// TriInterface.java
interface TriInterface {
    void aboutTriangle();
    double calculateTriangleArea();
}


// Triangle.java
class Triangle implements TriInterface {
    double baseLength; // base
    double height; // height
    public Triangle(double length, double height) {
        this.baseLength = length;
        this.height = height;
    }
    @Override
    public double calculateTriangleArea() {
        return 0.5 * baseLength * height;
    }
    @Override
    public void aboutTriangle() {
        System.out.println("Shape type: Triangle.");
    }
}


// Adapter.java
// Класс реализует RectInterface
class Adapter implements RectInterface {
    TriInterface triangle;
    Adapter(TriInterface triangle) {
        this.triangle = triangle;
    }
    @Override
    public void aboutMe() {
        triangle.aboutTriangle();
    }
    @Override
    public double calculateArea() {
        return triangle.calculateTriangleArea();
    }
}


// Client.java
class Client {
    public static void main(String[] args) {


// Экземпляр прямоугольника
        RectInterface rectangle = new Rectangle(20, 10);
// Экземпляр треугольника
        TriInterface triangle = new Triangle(20, 10);
// Использование адаптера для треугольника
        RectInterface adapter = new Adapter(triangle);


        // Хранилище всех объектов (для удобного перемещения по ним)
        List<RectInterface> rectangleObjects = new ArrayList<RectInterface>();


        try {
            rectangleObjects.add(rectangle);
            //rectangleObjects.add(triangle); // ОШИБКА КОМПИЛЯЦИИ
            rectangleObjects.add(adapter);
        }
        catch(Exception ex){
            ex.getMessage();
        }


        System.out.println("Processing the following objects:\n");
        for (RectInterface rectObject : rectangleObjects) {
            System.out.println("Area: " +
                    getDetails(rectObject) + " square units.\n");
        }
        GetRandomFigure(rectangleObjects);
    }


  // Вывод информации любого объекта (не знает, на входе прямоугольник или треугольник)
    static double getDetails(RectInterface rectangle) {
        rectangle.aboutMe();
        return rectangle.calculateArea();
    }

    static void GetRandomFigure(List<RectInterface> rectangleObjects) throws ArrayIndexOutOfBoundsException
    {
        Random random = new Random();
        int i = random.nextInt(10);

        if (i < 0 || i >= rectangleObjects.size())
            throw new ArrayIndexOutOfBoundsException("Случайно сгенерированное число вышло за пределы массива");
        else
            System.out.println("Area: " + getDetails(rectangleObjects.get(i)) + " square units.\n");

    }
}
