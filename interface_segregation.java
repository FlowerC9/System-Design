//interface should be such that client should not implement unnecessary functions they do not need

// Imagine you are designing a document management system in Java. To represent
// documents and their actions, you might create an interface called Document
// containing methods for opening, saving, printing, and sending via email. But
// what happens when some types of documents don’t need all of these functions?


//this is intial configuration which is not good we will discuss why

// That’s where ISP comes into play.
// public interface Document {
//     void open();

//     void save();

//     void print();

//     void sendViaEmail();
// }


//*****below we can see that to some classes ->
// don't need all the functionalities given in Document interface ****
//****so we can divide this iinterface such that client ->
// ****dont have to implement unnecessary functions

// public class PDFDocument implements Document {
//     public void open() {
//         // Logic for opening a PDF document
//     }

//     public void save() {
//         // Logic for saving a PDF document
//     }

//     public void print() {
//         // Logic for printing a PDF document
//     }

//     public void sendViaEmail() {
//         // Logic for sending a PDF document via email
//     }
// }

// public class WordDocument implements Document {
//     public void open() {
//         // Logic for opening a Word document
//     }

//     public void save() {
//         // Logic for saving a Word document
//     }

//     public void print() {
//         // Logic for printing a Word document
//     }

//     public void sendViaEmail() {
//         // Logic for sending a Word document via email
//     }
// }


//now we will implement as given below


interface openSave{
    void  open();
    void save();
}
interface print{
    void print_doc();
}
interface sendViaEmail{
    void send_Via_Email();
}

class PDFDocument implements openSave,print{
    public void open(){
        //logic for opening a file
    }
    public void save(){
        //logic for saving a file
    }
    public void print_doc(){
        //logic for printing the document
    }
}
class WordDocument implements openSave,sendViaEmail{
    public void open(){
        //logic for open
    }
    public void save(){
        //logic for save
    }
    public void send_Via_Email(){
        //logic for sending via email
    }
}

// With this new structure, each class only implements the interfaces that they
// need, avoiding the need to implement irrelevant methods. This makes our code
// clearer and easier to maintain.