import java.io.File;
import java.io.FileNotFoundException;
//Authors: Siyamthanda Phakathi and Stephan Jamieson
//Student number : PHKSIY006
//A java program simulating a marketplace with search functionality
import java.util.Scanner;

public class MarketPlace {
    
    private MarketPlace() {}
    
    private final static Currency RAND = new Currency("R", "ZAR", 100);
    
    
    // Create an instance of Seller with attributes ID, name, location, product, 
    // unit_price and number_of_units
    private static Seller makeSeller(final String data) {
        final Scanner scanner = new Scanner(data.trim());
        scanner.useDelimiter("\\s*,\\s*");


        Seller seller = new Seller();
        // Set the attributes to the values found in data
        seller.setId(scanner.next());
        seller.setName(scanner.next());
        seller.setLocation(scanner.next());
        seller.setProduct(scanner.next().trim());
        seller.setUnitPrice(new Money(scanner.next(),RAND));
        seller.setNumberOfUnits(Integer.parseInt(scanner.next()));

        return seller;
    }
    
    // Read the contents of CSV file into an array.
    // Creates an array of sellers
    private static Seller[] parseFile(final String fileName) throws FileNotFoundException {
        final Scanner inFile = new Scanner(new File(fileName));
        Seller[] sellers = null;
    
        if (inFile.hasNextLine()) {
            sellers = new Seller[Integer.parseInt(inFile.nextLine().trim())];
            for (int index=0; index<sellers.length; index++) {
                sellers[index] = makeSeller(inFile.nextLine());
            }

        }
        inFile.close();
        return sellers;
    }
    
    public static void main(final String[] args) throws FileNotFoundException {
        final Scanner inKey = new Scanner(System.in);
        System.out.println("Enter the name of a \"Comma Separated Values\" (CSV) file:");
        final Seller[] sellers = parseFile(inKey.nextLine());



        //Check if file has information by checking the array of sellers is not empty
        if (sellers == null || sellers.length == 0){

            System.out.println("The file contains no seller data.");
        }
        else {
            
            inKey.useDelimiter("\\n");
            System.out.println("Enter the name of a product:");
            String product = inKey.nextLine();
            System.out.println("Enter the number of units required:");
            int numUnits = inKey.nextInt();
            System.out.println("Enter the maximum unit price:");
            Money maxPrice = new Money(inKey.next(), RAND);
            
            //New array for the sellers matching the search description
            Seller[] sellersFound = new Seller[sellers.length];
            Boolean isEmpty = true;
            
            //for every item check if the unit price is less than/equals to the unit price, product is availabe and theres 
            // enough stock. If there is none then the array is empty
            for(int i = 0; i < sellers.length;i++){
        
                if((sellers[i].getUnitPrice().compareTo(maxPrice) < 0 || sellers[i].getUnitPrice().equals(maxPrice)) &&
                        sellers[i].getNumberOfUnits() >= numUnits &&
                        product.equals(sellers[i].getProduct())){

                    sellersFound[i] = sellers[i];
                    isEmpty = false;
                }
                else{
                    sellersFound[i] = null;
                }

            }
            if (isEmpty){
                System.out.println("None found.");
            }
            //print all the values in the array that are not null
            else{
                   for(Seller seller : sellersFound){
                       if (seller == null ){
                           ;
                       }
                       else{
                           System.out.println(seller.getId() + " : " + seller.getName() + " in " + seller.getLocation()+ " has " + seller.getNumberOfUnits() + " " + product + " for " + seller.getUnitPrice().toString() + " each.");
                       }
                }
            }


        }

    }
}
