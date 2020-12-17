import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadWrite {

    public  void Writejson(String Filename,ArrayList<PersonInfo> addressbook) throws Throwable {
        String path="C:\\Users\\rohit\\Documents\\AddressBook_io\\"+Filename;
        Gson gson = new Gson();
        String json = gson.toJson(addressbook);
        FileWriter writer = new FileWriter(path);
        writer.write(json);

        writer.flush();
        writer.close();
    }

    public ArrayList<PersonInfo> readjso(String Filename) throws Throwable {
        List<PersonInfo> Person = null;
        try {
            // JSON array
            String json = "[{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"," +
                    "\"roles\":[\"Member\",\"Admin\"],\"admin\":true},{\"name\":\"Tom Lee\"," +
                    "\"email\":\"tom.lee@example.com\",\"roles\":[\"Member\"],\"admin\":false}]";

            // convert JSON array to Java List
            Person = new ObjectMapper().readValue(json, new TypeReference<List<PersonInfo>>() {
            });

            // print list of users
            Person.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (ArrayList<PersonInfo>) Person;

    }


        public  void Writecsv(String Filename,ArrayList<PersonInfo> addressbook) throws Throwable {
        String path="C:\\Users\\rohit\\Documents\\AddressBook_io\\"+Filename;
        CSVWriter writer=new CSVWriter(new FileWriter(path));
        String line1[]= {"Firstname","Lastname","address","city","state","zip","mobilenumber"};
        String var =  String.join(",",line1);
        writer.writeNext(new String[]{var});
        for(int a=0;a<addressbook.size();a++) {
            PersonInfo index=addressbook.get(a);
            String line2[]= {index.getFirstname(),index.getLastname(),index.getAddress(),index.getCity(),index.getState(),index.getZip(),String.valueOf(index.getNumber())};
            String var1 =  String.join(",",line2);
            writer.writeNext(new String[]{var1});

        }
        writer.flush();
        writer.close();
    }

    public  void Writetxt(String Filename,ArrayList<PersonInfo> addressbook) throws Throwable {
        String path="C:\\Users\\rohit\\Documents\\AddressBook_io\\"+Filename;
        BufferedWriter writer=new BufferedWriter(new FileWriter(path));
        String line1[]= {"Firstname","Lastname","address","city","state","zip","mobilenumber"};
        String var =  String.join(",",line1);
        writer.write(var);
        for(int a=0;a<addressbook.size();a++) {
            PersonInfo index=addressbook.get(a);
            String line2[]= {index.getFirstname(),index.getLastname(),index.getAddress(),index.getCity(),index.getState(),index.getZip(),String.valueOf(index.getNumber())};
            String var1 =  String.join(",",line2);
            writer.newLine();
            writer.write(var1);

        }
        writer.flush();
        writer.close();
    }

    public ArrayList<PersonInfo> readFile(String Filename) throws Throwable {
        String path="C:\\Users\\rohit\\Documents\\AddressBook_io\\"+Filename;
        BufferedReader BR=new BufferedReader(new FileReader(path));
        ArrayList<PersonInfo> person=new ArrayList<PersonInfo>();
        String line=null;
        int i=0;
        while ((line=BR.readLine())!=null) {
            i=i+1;
            if (i!=1) {
                String[] value=line.split(",");
                person.add(new PersonInfo(value[0].substring(1,value[0].length()-1),value[1].substring(1,value[1].length()-1),value[2].substring(1,value[2].length()-1),value[3].substring(1,value[3].length()-1),value[4].substring(1,value[4].length()-1),value[5].substring(1, value[5].length()-1),(value[6].substring(1, value[6].length()-1))));
            }
        }
        BR.close();
        return person;
    }
    public void showfiles() {
        File folder=new File("C:\\Users\\rohit\\Documents\\AddressBook_io\\");
        File file[]=folder.listFiles();
        System.out.println("list of files");
        for(File name:Objects.requireNonNull(file)) {
            String filename=name.getName();
           // if(filename.contains()) {
                System.out.println(filename);

            //}
        }
    }
}

