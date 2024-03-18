//class should depend on interface rather than concrete class
//High level module should not import anything from low level module instead both should depend on 
//abstraction(eg: interfaces)

import java.util.ArrayList;
import java.util.List;

// class Manager {
//     private List<Developer> developers;
//     private List<Designer> designers;
//     private List<Testers> testers;

//     public Manager() {
//         developers = new ArrayList<>();
//         designers = new ArrayList<>();
//         testers = new ArrayList<>();
//     }

//     public void addDeveloper(Developer dev) {
//         developers.add(dev);
//     }

//     public void addDesigners(Designer design) {
//         designers.add(design);
//     }

//     public void addTesters(Testers tester) {
//         testers.add(tester);
//     }
// }

// class Developer {
//     public Developer() {
//         System.out.println("developer added");
//     }
// }

// class Designer {
//     public Designer() {
//         System.out.println("designer added");
//     }
// }

// class Testers {
//     public Testers() {
//         System.out.println("tester added");
//     }
// }

// class Main {
//     public static void main(String[] args) {
//         Manager a = new Manager();
//         a.addDeveloper(new Developer());
//         a.addDesigners(new Designer());
//     }
// }
// Now, let’s look at the design loop holes in the source code : First, you have
// exposed everything about the lower layer to the upper layer, thus abstraction
// is not mentioned. That means Manager must already know about the type of the
// workers that he can supervise. Now if another type of worker comes under the
// manager lets say, QA (quality assurance), then the whole class needs to be
// rejigged. This is where dependency inversion principle pitch in. Let’s see
// how to solve the problem to the better extent using Dependency Inversion
// Principle.
interface Employee{
    public void work();
}
class Manager{
    List<Employee>employees;
    Manager(){
        employees=new ArrayList<>();
    }
    void addEmployee(Employee e){
        employees.add(e);
    }
}

class Designer implements Employee{
    public Designer(){
        System.out.println("Designer added");
    }
    public void work(){
        System.out.println("turning lines into wireframes");
    }
}

class Developer implements Employee {
    public Developer() {
        System.out.println("Developer added");
    }

    public void work() {
        System.out.println("turning coffee into code");
    }
}

class Testers implements Employee {
    Testers() {
        System.out.println("tester added");
    }

    public void work() {
        System.out.println("testing everything out there");
    }
}

public class dependency_inversion_principle{
    public static void main(String[] args) {
        Manager manager=new Manager();
        manager.addEmployee(new Developer());
        manager.addEmployee(new Testers());
        manager.addEmployee(new Designer());
        // now if i want to add any other type of employee i can simply implement
        // the Employee interface
    }
}

// In this code, the manager doesn’t have an idea beforehand about all the type
// of workers that may come under him/her making the code truly decoupled. There
// are many design patterns where this is a core idea and other things are built
// upon it