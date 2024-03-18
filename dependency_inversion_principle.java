//class should depend on interface rather than concrete class
//High level module should not import anything from low level module instead both should depend on 
//abstraction(eg: interfaces)

import java.util.ArrayList;
import java.util.List;

class Manager {
    private List<Developer> developers;
    private List<Designer> designers;
    private List<Testers> testers;

    public Manager() {
        developers = new ArrayList<>();
        designers = new ArrayList<>();
        testers = new ArrayList<>();
    }

    public void addDeveloper(Developer dev) {
        developers.add(dev);
    }

    public void addDesigners(Designer design) {
        designers.add(design);
    }

    public void addTesters(Testers tester) {
        testers.add(tester);
    }
}

class Developer {
    public Developer() {
        System.out.println("developer added");
    }
}

class Designer {
    public Designer() {
        System.out.println("designer added");
    }
}

class Testers {
    public Testers() {
        System.out.println("tester added");
    }
}

class Main {
    public static void main(String[] args) {
        Manager a = new Manager();
        a.addDeveloper(new Developer());
        a.addDesigners(new Designer());
    }
}
