package casecoolors.Exception;

import java.awt.*;

public class ExistImageException extends RuntimeException{
    public ExistImageException(String name){
        super("Image name: " + name + " already exists.");
    }
}
