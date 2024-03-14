class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

// lets suppose we introduce a gst factor so the only calculateTotal changes so
// Single Responsibilty
// is follwing
class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // only one
    public int calculateTotal() {
        int price = marker.price * this.quantity;
        return price;
    }
}

// Data access layer is formed to save to db and printinvoice
//we must not  change the existing class otherwise it might cause bugs

// ----->
// class invoiceDao {
//     Invoice invoice;

//     public invoiceDao(Invoice invoice) {
//         this.invoice = invoice;
//     }

//     public void saveToDb() {
//         // save into DB
//     }
// }

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        // Print the invoice
    }
}

//open close

//lets say we want to save the data in mysql and mongodb
// so it should go like this
//open to extension but close to modification

interface invoiceDao{
    public void save(Invoice invoice);
}

class mysqlInvoiceDao implements invoiceDao{
    @Override
    public void save(Invoice invoice){
        //save to mysql
    }
}

class mongodbInvoiceDao implements invoiceDao{
    public void save(Invoice invoice){
        //save to mongodb
    }
}