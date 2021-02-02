public class ShapeMaker {

    public static void main(String[] args) {

        Circle[] circle = {new Circle(20),
                           new Circle(40),
                           new Circle(50)};

        RectAngle[] rect = {new RectAngle(20, 20),
                            new RectAngle(50, 60)};

        for (int i = 0; i < circle.length; i++)
            circle[i].draw();

        for (int i = 0; i < rect.length; i++)
            rect[i].draw();
    }
}
