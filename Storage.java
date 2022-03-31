import java.util.Scanner;

public class Storage {

    public int numOfProducts = 0;
    public Product[] listOfProducts;
    //Storage class constructor for creating the storage array
    public Storage(){
        listOfProducts = new Product[3];
    }
    TitleCase t = new TitleCase();

    public void addProduct(Scanner scanner){
        boolean isShelfFree = true;
        System.out.println("Podaj nazwę produktu:");
        String userProductName = scanner.nextLine();
        System.out.println("Podaj cenę produktu:");
        double userProductPrice = scanner.nextDouble();
        while(isShelfFree) {//loop runs until empty shelf is picked
            System.out.println("Podaj nr półki na której chcesz umieścić produkt");
            this.displayProducts();
            int numOfIndex = scanner.nextInt();
            scanner.nextLine();
            if (numOfIndex - 1 >= listOfProducts.length || numOfIndex - 1 < 0) { //check if shelf number is outside 1-3
                System.out.println("Nie ma takiej półki.");
            } else if (listOfProducts[numOfIndex - 1] != null) {//check if shelf already has a product on it
                System.out.println("Na tej półce znajduje się już produkt. Sprobuj jeszcze raz");
            } else {//execute if empty shelf is picked - add product to the list
                listOfProducts[numOfIndex - 1] = new Product(t.titleCase(userProductName), userProductPrice);
                System.out.println("Pomyślnie dodano produkt.");
                isShelfFree = false;
                numOfProducts++;
            }
        }
    }

    public void deleteProduct(Scanner scanner){
        System.out.println("Produkt z której półki chcesz usunąć?\n");
        this.displayProducts();
        int numOfIndex = scanner.nextInt();
        scanner.nextLine();
        listOfProducts[numOfIndex - 1] = null;
        numOfProducts--;
    }
    public void displayProducts() {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] != null) {
                System.out.println("Na półce nr " + (i + 1) + " znajduje się " + listOfProducts[i].getProductName() + ". Cena: " + listOfProducts[i].getProductPrice());
            } else {
                System.out.println("Półka nr " + (i + 1) + " jest " + "pusta");
            }
        }
    }
    public void shipProducts(Scanner scanner){
        System.out.println("Podaj nazwę kontrahenta.");
        String userName = scanner.nextLine();
        System.out.println("Podaj ilość produktów, jaką chcesz wysłać.\nAktualnie w magazynie znajduje/ą się " + numOfProducts + " produkty/ów.");
        int userNum = scanner.nextInt();
        scanner.nextLine();
        String[] listOfProductsToShip = new String[userNum];
        if(userNum > numOfProducts){//if users provides a number larger than number of items in the storage, prompt for a new number
            System.out.println("W magazynie znajduje/ą się tylko " + numOfProducts +" produkty." );
            System.out.println("Jeszcze raz podaj ilość produktów, jaką chcesz wysłać.");
            userNum = scanner.nextInt();
            scanner.nextLine();
        }
        this.displayProducts();
        System.out.println("\nProdukty z których półek chcesz wysłać?");
        int index = 0;
        int pickedShelf;
        do{//user picks the shelves for shipping
            System.out.println("Podaj nr półki.");
            pickedShelf = scanner.nextInt();
            scanner.nextLine();
            listOfProductsToShip[index] = listOfProducts[pickedShelf - 1].getProductName();//add the name of the product to list of shipped products
            listOfProducts[pickedShelf -1] = null;
            index++;
            userNum--;
        }while(userNum > 0);
        System.out.println("Udało się pomyślnie wysłać:");//list information about shipped products
        for(int i = 0; i < listOfProductsToShip.length; i++){
            if(listOfProductsToShip[i] != null) {
                System.out.println(listOfProductsToShip[i]);
                listOfProductsToShip[i] = null;
            }
        }
        System.out.println("do " + t.titleCase(userName) + ".\n");
        System.out.println("Aktualny stan magazynu:");
        this.displayProducts();
    }
}




