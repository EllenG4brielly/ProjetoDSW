package Factorys;

import Shapes.Circle;
import Shapes.Elipse;
import Shapes.Shape;

public class CircFactory extends ShapeFactory{

    @Override
    public Shape getShape(String s) {
        if (s == "c"){
            return new Circle();

        }else if (s == "e"){
            return new Elipse();
        }else {
            return null;
        }
    }
}
