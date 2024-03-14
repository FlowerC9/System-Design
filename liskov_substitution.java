//Subclass Should extend the capability of parent class not narrow it down

interface shape{
    int getWidth();
    void setWidth(int width);
    int getHeight();
    void setHeight(int height);
    int area();
}

class reactangle implements shape{
    private int width,height;
    public reactangle(int height,int width){
        this.height=height;
        this.width=width;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public int area(){
        return height*width;
    }
}

class square implements shape{
    private int size;
    public square(int size){
        this.size=size;
    }
    
    public int getHeight() {
        return size;
    }

    public int getWidth() {
        return size;
    }

    public void setHeight(int size) {
        this.size = size;
    }

    public void setWidth(int size) {
        this.size = size;
    }

    public int area() {
        return size * size;
    }
}

/**
 * liskov_substitution
 */
public class liskov_substitution {

    public static void process(shape s){
        int h=s.getHeight();
        s.setWidth(10);
        System.out.println("Expected area : "+h*10+" | we got : "+s.area());
    }
    public static void main(String[] args) {
        shape s1=new reactangle(45, 20);
        process(s1);
        shape s2=new square(12);
        process(s2);
    }
}