import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMainTest extends AddressBook  {

    public static void main(String[] args) throws Throwable {
        System.out.println("Welcome to address book");
        ReadWrite readWrite=new ReadWrite();
        AddressBookMainTest addressBook=new AddressBookMainTest();
        ArrayList<PersonInfo> personList=new ArrayList<PersonInfo>();
        Scanner scanner=new Scanner(System.in);
        boolean i=true;
        while(i){
            System.out.println("1) new address book \n"+"2) addPerson   \n"
                    +"3) editPerson\n"+"4) deletePerson\n"+"5) sortByname\n"+"6) sortby zip or city or state\n"+"7) searchPerson\n"
                    +"8) view addressbook\n"+"9) count no of persons\n"+"10) save address-book");
            System.out.println(" ");
            System.out.println("please enter your choice");
            int number=scanner.nextInt();
            readWrite.showfiles();
            System.out.println("Enter the file name to open   or    press any number to move forward");
            String Filename=scanner.next();
            switch (number) {
                case 1:
                    addressBook.newAddressBook();
                    break;
                case 2:
                    personList= addressBook.addPerson(Filename);
                    break;
                case 3:
                    personList=addressBook.editPerson(Filename);
                    break;
                case 4:
                    personList=addressBook.deletePerson(Filename);
                    break;
                case 5:
                    addressBook.sortByName(Filename);
                    break;
                case 6:
                    addressBook.sortByOthers(Filename);
                    break;
                case 7:
                    addressBook.searchPerson(Filename);
                    break;
                case 8:
                    addressBook.ViewPerson();
                    break;
                case 9:
                    addressBook.countNoOfPersons(Filename);
                    break;
                case 10:
                    addressBook.saveAddressBook(Filename,personList);
                    break;
                default:
                    System.out.println("Please enter valid number");
            }
            System.out.println("do you want to continue(Y/N)?");
            String var=scanner.next();
            if(var.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                break;
            }

        }
    }

}

