package Factorys;

import Shapes.*;

public class QuadFactory extends ShapeFactory {
    @Override
    public Shape getShape(String s) {

        if (s == "s"){
            return new Square();
        }else if (s == "r"){
            return new Rectangle();
        }else {
            return null;
        }


    }
}
