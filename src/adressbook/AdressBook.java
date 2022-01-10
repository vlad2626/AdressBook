/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author valmi
 */
public class AdressBook {

    /**
     * @param args the command line arguments
     */
    Scanner sc = new Scanner (System.in);
    File ADB=new File("AdressBook.txt");
    
    public static  void main(String[] args) throws IOException {
        // TODO code application logic here
       AdressBook AB = new AdressBook();
        
        if (AB.ADB.createNewFile())
        {
            System.out.println("File created");
        }
        
       int MenuChoice;
       
     
     do
     {
       MenuChoice = -1;
         MenuChoice=AB.MainMenu(MenuChoice);
       AB.sc.nextLine();// reset the keboard reader
    
       AB.menu(MenuChoice);
     }while(MenuChoice !=4);
        
      
    }
    
    public  void createFile()
    {
        File ADB =new File("AdressBook.txt");
        System.out.println("File created");
      
         
        // test if the file is currently empty
    }
    
    public  int MainMenu(int menuChoice)
    {
        System.out.println(" Main Menu. \n1.New contact \n2.Update existing contact \n3.Delete Contact \n4. Exit ");
        
       
        menuChoice = sc.nextInt();
        // validate user entry
        if (menuChoice <0 || menuChoice >4)
        {
            System.out.println("Invalid number selected");
            menuChoice= sc.nextInt();
        }
        
        return menuChoice;
    }
    
    public  void menu(int menChoice) throws IOException
    {
        
        
       
            
        
        if (menChoice == 1)
        {
            newContact();
        }
         if (menChoice == 2)
        {
            Update();
        }
          if (menChoice == 3)
        {
            Delete();
        }
           if (menChoice == 4)
        {
            System.out.println("Exiting program ");;
        }
  
    }
    
    
    public void newContact()
    {
        // this will check if a contact already exist  then add to the file and
        String first, last, nickname , gender,  number;
        String phone;
        
        System.out.println("/n New contact , Please enter first and last name 1 space only ");
        first = sc.nextLine();
        
       
        
       
        
        System.out.println(" Nickname");
        nickname = sc.nextLine();
        
        
       
        // could also do this with a try cath loop.
        String[] ph ;
        
     
        System.out.println("Please enter a valid phone number ");
        phone = sc.nextLine();

            
        
       
       
      
        do
        {    
            System.out.println("Please enter a valid Gender");
            gender=sc.nextLine();
        
            
        }while (!(gender.equalsIgnoreCase("M") || (gender.equalsIgnoreCase("F"))));
        
        People person = new People(first, nickname, gender, phone);
        
        System.out.println(person.toString());
        String ans;
        // validate if use would like to save
        do{
            System.out.println("Would you like to save(Y/N)");
            ans = sc.nextLine();
        }
        while(!(ans.equalsIgnoreCase("y") ||ans.equalsIgnoreCase("n"))); 
        
       if(ans.equalsIgnoreCase("y"))
       {
           System.out.println(Save(person));
       }
       else
       {
           System.out.println("Contact not saved");
       }
        
        
    }
    
    
    public static String Save(People person) 
    {
        try{
            FileWriter fw = new FileWriter("C:\\Users\\valmi\\Documents\\NetBeansProjects\\AdressBook\\AdressBook.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(person.writeFile());
            bw.newLine();
            bw.close();
       
       
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e){
            
        }
        return " saved";
    }
    
    
    
    
    
    
    
    
    
    
    public  void Update() throws IOException
    {
        System.out.println(" Please enter the name of the person g ");
        String name = sc.nextLine();
        String name2, nickname2,phone2,gender2;
        People newEntry;
       
        // maybe not legal . idk 
          People person = find(name);
          System.out.println("Is this the name you would like to edit  (y/n)");
          String confirm = sc.nextLine();
          if(confirm.equalsIgnoreCase("y"))
          {
              System.out.println("update your fields");
              {
                  System.out.println("Name");
                  name2 =sc.nextLine();
                  
                  System.out.println("nickName");
                  nickname2 =sc.nextLine();
                  
                  
                  System.out.println("Phone");
                  phone2 =sc.nextLine();
                  
                  System.out.println("Gender");
                  gender2 =sc.nextLine();
                  
                  newEntry = new People(name2, nickname2,phone2,gender2);
                  // deletes old entry and saves new entry. 
                  Delete(person);
                  Save(newEntry);
                  
              }
          }
          else
          {
              // advance stuff to loop the program to main menu
          }
                  
    }
    
    
    public void updateEntry(People person) throws IOException 
    {
        
        FileWriter fw = new FileWriter("AdressBook.txt");
        Scanner rf = new Scanner("AdressBook.txt");
        String line;
        String fName = person.getName();
        Boolean found;
        
        do
        {
            found = false;
            line = rf.nextLine();
            if (line.contains(fName))
            {
                found = true;
            }
            else
            {
                found = false;
            }
                    
                        
                    
        }while(rf.hasNextLine());
        
        
    }
    
    public void Delete(People person)
    {
     BufferedReader br = null;
      FileReader fr ;
     String line;
     String []temp;
     boolean found;
     ArrayList <String> words = new ArrayList<>();
     System.out.println(words);
            
        try {   
            fr = new FileReader(ADB);
            br = new BufferedReader(fr);
            
            
             do
        {
            line = br.readLine();
            System.out.println(line);
            
            temp = line.split(" ");
            // skip the one that it is equal to. 
            if (person.getName().equalsIgnoreCase(temp[0]))
                {
                    System.out.println("found to delete:" + temp[0]);
                   

                }
            else
            {
                words.add(line);
                System.out.println(temp[0]);
            }
        }   while (br.readLine() != null);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdressBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdressBook.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
         try {
             br.close();
         } catch (IOException ex) {
             Logger.getLogger(AdressBook.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
        System.out.println(words);
         PrintWriter pw = null;
        try {
           pw = new PrintWriter("AdressBook.txt");
            for(String st :  words)
            {
                pw.println(st);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            pw.close();
        }
    
        
       
        
        
       
    }
    
    
    public void Delete()
    {
        System.out.println("Enter the name of the person you would like to delete");
        String ans = sc.nextLine();
        People person =find(ans);
        System.out.println("Are you sure you want to delete  Y/N " + person.getName());
        ans = sc.nextLine();
        if(ans.equalsIgnoreCase("y"))
        {     
        Delete(person);
    
        }
        else
        {
            System.out.println("Aborting");
        }
    }
    
    public People find(String name)
    {
        // empty string to read the whole line
        String line = "";
        String  first, phone , gender, nickname;
        People temp;
        String [] person = null;
        
        Scanner readFile; 
        Boolean found = false;
        // this method is designed to  pass unless the name is not found . throw scanner exception  since file will be too long;
        try
        {
            readFile= new Scanner(ADB);
            do
            {
                  line = readFile.nextLine();
                  
              
                person = line.split(" ");
                found = true;
            }while(!(person[0].equalsIgnoreCase(name)));
        }catch(Exception e)
        {
            found = false;
            System.out.println("Find Exception  or name not found");
        }
        // checks the boolean and returns the correct value . 
        if(found)
        {
            first = person[0];
            nickname = person[1];
            phone = person[2];
            gender = person[3]; 
            temp = new People(first,nickname,phone,gender);
        }else
        {
            temp = null;
        }
        
        
        return temp;
    }
    
    
    
}
