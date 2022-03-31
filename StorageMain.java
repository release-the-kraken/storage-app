/*
Storage management console app. Functionalities include: adding new products, deleting products, listing products and shipping products.
Allows for saving the product list to a json file and reading the file on app start. Title cases product and customer names.
Further development:
- validate user input for type,
- improve titleCase method to allow for title casing more than 1 word,
- export info on shipments to a json file.
 */
import java.util.Scanner;

public class StorageMain {
    public static void main(String[] args) {
        runApp();
    }
    private static void runApp(){
        Scanner scanner = new Scanner(System.in);
        Storage store = new Storage(); //calling the Storage class constructor to create a new Product array
        JSONReadWrite json = new JSONReadWrite();
        String fileName = "ProductList.json";
        json.readFromJSON(store.listOfProducts, fileName);//reading storage contents saved in previous session
        for(int i = 0; i < store.listOfProducts.length; i++){//updating the number of products variable based on loaded content
            if(store.listOfProducts[i] != null){
                store.numOfProducts++;
            }
        }
        //System.out.println(store.numOfProducts);
        int userChoice;
        System.out.println("Witamy w aplikacji Obsługomagazynoinator");
        do {
            System.out.println("Wybierz opcję\n 1-Dodaj produkt\n 2-Dsuń produkt\n 3-Wydrukuj listę produktów\n 4-Wyślij produkt/y\n 0-Zakończ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    store.addProduct(scanner);
                    break;
                case 2:
                    store.deleteProduct(scanner);
                    break;
                case 3:
                    store.displayProducts();
                    break;
                case 4:
                    store.shipProducts(scanner);
                    break;
                default:
                    json.writeToJSON(store.listOfProducts, fileName);//saving contents of storage list to file
                    System.out.println("Do widzenia.");
            }
        }while(userChoice != 0);

    }
}
