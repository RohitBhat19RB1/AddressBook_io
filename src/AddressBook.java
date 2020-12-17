import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class AddressBook extends ReadWrite {
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String zipcode;
    public String number;
    Scanner scanner = new Scanner(System.in);


    public void newAddressBook() throws Throwable {
        ArrayList<PersonInfo> personarraylist=new ArrayList<PersonInfo>();
        System.out.println("create a file with (.txt or .csv or .json) extension");
        String Filename=scanner.next();
        File file=new File("C:\\Users\\rohit\\Documents\\AddressBook_io\\"+Filename);
        if(file.createNewFile()) {
            Writejson(Filename, personarraylist);
            System.out.println("File is created");
        }else{
            System.out.println("File already exists");
        }
    }

    public ArrayList<PersonInfo> addPerson(String Filename) throws Throwable {
        ArrayList<PersonInfo> addPerson=readFile(Filename);
        System.out.println("Please enter the number of person to be added");
        int noOfPersons=scanner.nextInt();
        int dupilicateData=0;
        for (int i=0;i<noOfPersons;i++) {
            System.out.println("Enter Firstname :");
            firstname = scanner.next();
            System.out.println("Enter Lastname :");
            lastname = scanner.next();
            System.out.println("Enter address:");
            address = scanner.next();
            System.out.println("Enter city:");
            city = scanner.next();
            System.out.println("Enter state:");
            state = scanner.next();
            System.out.println("Enter zipcode:");
            zipcode = scanner.next();
            System.out.println("Enter mobilenumber");
            number = scanner.next();
            for(int j=0;j<addPerson.size();j++){
                if(firstname.equalsIgnoreCase(addPerson.get(j).getFirstname())){
                    dupilicateData++;
                }
            }
            if (number.matches("\\d{10}")&&(dupilicateData==0) && (zipcode.matches("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$"))) {
                addPerson.add(new PersonInfo(firstname, lastname, address, city, state, zipcode, number));
                System.out.println("size of an array list after adding person" + addPerson.size());
            } else if(dupilicateData==1){
                System.out.println("Data already exists");
            } else {
                System.out.println("Please enter valid phone number and zip");
            }
        }
        return addPerson;
    }

    public ArrayList<PersonInfo> editPerson(String Filename) throws Throwable {
        ArrayList<PersonInfo> editPerson = readFile(Filename);
        System.out.println("Enter your edit person details");
        String search = scanner.next();
        for (int i = 0; i <editPerson.size(); i++) {
            if (search.equalsIgnoreCase(editPerson.get(i).getFirstname())) {
                firstname = editPerson.get(i).getFirstname();
                lastname = editPerson.get(i).getLastname();
                System.out.println("Enter address:");
                address = scanner.next();
                System.out.println("Enter city:");
                city = scanner.next();
                System.out.println("Enter state");
                state = scanner.next();
                System.out.println("Enter zipcode:");
                zipcode = scanner.next();
                System.out.println("Enter phone number:");
                number = scanner.next();
                if (number.matches("\\d{10}") && (zipcode.matches("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$"))) {
                    PersonInfo edit = editPerson.set(i, (new PersonInfo(firstname, lastname, address, city, state, zipcode, number)));
                    System.out.println(edit);
                    System.out.println(editPerson.get(i));
                } else {
                    System.out.println("please enter valid phonenumber and zip");
                }
            }
        }
        return editPerson;
    }

    public ArrayList<PersonInfo> deletePerson(String Filename) throws Throwable {
        ArrayList<PersonInfo> deletePerson=readFile(Filename);
        System.out.println("Enter your delete person details");
        String delPerson=scanner.next();
        for (int i=0;i<deletePerson.size();i++){
            if(delPerson.equalsIgnoreCase(deletePerson.get(i).getFirstname())){
                deletePerson.remove(i);
                System.out.println("size of array list after deleting the person"+deletePerson.size());
            }
        }
        return deletePerson;
    }

    public void sortByName(String Filename) throws Throwable {
        ArrayList<PersonInfo> sortByName=readFile(Filename);
        sortByName.stream().sorted((o1,o2)->o1.getFirstname().compareToIgnoreCase(o2.getFirstname())).forEach(System.out::println);
    }

    public void sortByOthers(String Filname) throws Throwable{
        ArrayList<PersonInfo> sortByOthers=readFile(Filname);
        System.out.println("choose how u want to sort");
        System.out.println("1)sortByZip\n"+"2)sortBycity\n"+"3)sortBystate");
        int sortByOther=scanner.nextInt();
        switch (sortByOther){
            case 1:
                sortByOthers.stream().sorted((o1,o2)->o1.getZip().compareToIgnoreCase(o2.getZip())).forEach(System.out::println);
                break;
            case 2:
                sortByOthers.stream().sorted((o1,o2)->o1.getCity().compareToIgnoreCase(o2.getCity())).forEach(System.out::println);
                break;
            case 3:
                sortByOthers.stream().sorted((o1,o2)->o1.getState().compareToIgnoreCase(o2.getState())).forEach(System.out::println);
                break;
            default:
                System.out.println("Please enter correct ooption");
        }
    }

    public void searchPerson(String Filename) throws Throwable {
        ArrayList<PersonInfo> searchPerson=readFile(Filename);
        System.out.println("Enter city or state to search");
        String search=scanner.next();
        searchPerson.stream().filter(o->o.getState().equalsIgnoreCase(search)||o.getCity().equalsIgnoreCase(search)).forEach(System.out::println);

    }
    public void countNoOfPersons(String Filename) throws Throwable{
        ArrayList<PersonInfo> countPersons=readFile(Filename);
        System.out.println("Enter city or state to count no of persons");
        String countNoOfPersons=scanner.next();
        int count=(int)countPersons.stream().filter(o->o.getCity().equalsIgnoreCase(countNoOfPersons)||o.getState().equalsIgnoreCase(countNoOfPersons)).count();
        System.out.println("count no of persons::"+count);
    }

    public void ViewPerson() throws Throwable{
        ArrayList<PersonInfo> merge=new ArrayList<PersonInfo>();
        System.out.println("Enter no of adressbook you want to merge");
        int noOfAddressBook= scanner.nextInt();
        for(int i=0;i<noOfAddressBook;i++){
            System.out.println("Enter a file name u want to add to the arraylist view person");
            String File=scanner.next();
            ArrayList<PersonInfo> viewPerson=readFile(File);
            merge.addAll(viewPerson);
        }
        System.out.println("Enter city or state to view person from multiple addressbook");
        String view=scanner.next();
        merge.stream().filter(o->o.getState().equalsIgnoreCase(view)||o.getCity().equalsIgnoreCase(view)).forEach(System.out::println);
    }


    public void saveAddressBook(String Filename, ArrayList<PersonInfo> save) throws Throwable {
        Writejson(Filename, save);
    }
}

