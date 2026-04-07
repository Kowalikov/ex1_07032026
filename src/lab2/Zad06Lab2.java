/*
Zadanie 6:
Zaimplementuj klasę Invoice reprezentującą fakturę dla sklepu.
Klasa przechowuje następujące informacje: product_number (typ String),
prodcut_description (typ String), quantity(typ int) ipricePerItem`(typ double).
Klasa powinna mieć konstruktor, który umożliwi podanie wszystkich 4 parametrów.
Zaimplementuj metody set i get dla każdej zmiennej. Dodaj metodę:

- Amount, które zwraca iloczyn quantity i pricePerItem. Jeżeli pricePerItem
  nie jest dodatnia, Amount powinien zwrócić 0. Jeżeli quantity nie jest dodatnie,
  Amount powinna zwrócić 0.

Przetestuj zaimplementowany program.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad06Lab2 {
    public static class Invoice {
        private String productNumber;
        private String productDescription;
        private int quantity;
        private double pricePerItem;


        public Invoice(String pNum, String pDescr, int quant, double ppi) {
            productNumber = pNum;
            productDescription = pDescr;
            quantity = quant;
            pricePerItem = ppi;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPricePerItem(double pricePerItem) {
            this.pricePerItem = pricePerItem;
        }

        public String getProductNumber() {
            return productNumber;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPricePerItem() {
            return pricePerItem;
        }

        public double amount() {
            if (pricePerItem < 0) return 0;
            if (quantity < 0) return 0;
            return pricePerItem*quantity;
        }

        public void displayInvoice() {
            IO.println("Invoice: ");
            IO.println("\tProduct number:      " + productNumber);
            IO.println("\tProduct description: " + productDescription);
            IO.println("\tQuantity:            " + quantity);
            IO.println("\tPrice per item:      " + pricePerItem);
        }
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice("10056", "Szczypiorek", 3, 3.99);

        invoice.displayInvoice();
        IO.println("\tTotal amount:        " + invoice.amount());

        invoice.setQuantity(-1);
        invoice.displayInvoice();
        IO.println("\tTotal amount:        " + invoice.amount());

    }
}
