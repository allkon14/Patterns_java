import java.util.ArrayList;
import java.util.List;


interface Shape {
    public void draw(String fillColor);
}
class Triangle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color "+fillColor);
    }

}
class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
    }

}
class Drawing implements Shape{
    //коллекция фигур
    private List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void draw(String fillColor) {
        for(Shape sh : shapes)
        {
            sh.draw(fillColor);
        }
    }

    //добавление фигуры для рисования
    public void add(Shape s){
        this.shapes.add(s);
    }

    //удаление фигуры
    public void remove(Shape s){
        shapes.remove(s);
    }

    //удаление всех фигур
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}
class Composite {
    public static void main(String[] args) {
        //создание нескольких фигур
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        //добавляем фигуры в список для рисования
        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        //закрашиваем все фигуры красным
        drawing.draw("Red");

        //очистка
        drawing.clear();

        //добавляем новые фигуры, закрашивая их зеленым
        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}
