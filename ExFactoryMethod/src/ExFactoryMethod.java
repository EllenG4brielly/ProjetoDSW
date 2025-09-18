import Factorys.CircFactory;
import Factorys.QuadFactory;
import Factorys.ShapeFactory;
import Shapes.Shape;

public class ExFactoryMethod {
    public static void main(String[] args) {
        ShapeFactory cf = new CircFactory(); //instanciou agr eles consegue
        ShapeFactory qf = new QuadFactory();

        Shape c = cf.getShape("c");
        c.draw();
        Shape e = cf.getShape("e");
        e.draw();
        Shape r = qf.getShape("r");
        r.draw();
        Shape s = qf.getShape("s");
        s.draw();

    }
}
