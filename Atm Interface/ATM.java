import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Enter Your Name :");
        ATM.name=sc.nextLine();
        System.out.println("Enter Your Username :");
        String userID=sc.nextLine();
        System.out.println("Enter Your Password :");
        String password=sc.nextLine();
        System.out.println("Enter your Account Number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("You are Successfully Registered!!!");
        System.out.println("***********************");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int option=sc.nextInt();
            if(option==1){
                login(userID,password);
                break;
            }
            else {
                if(option==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Try Again!!!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String userID,String password){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("********************");
        System.out.println("Enter the amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println(wcash+"is successfully withdrawn");
            System.out.println("***********************");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("*************************");
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("*****************");
        System.out.print("Enter amount to deposit :");
        int deposit=sc.nextInt();
        ATM.updatebalance(deposit);
        ATM.history.add(Integer.toString(deposit));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+deposit+"/- deposit successful!");
        System.out.println("*********************");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiver name");
        String s=sc.nextLine();
        System.out.println("Enter Receiver Account Number");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int trans=sc.nextInt();
        if(trans<=ATM.balance){
            ATM.balance=ATM.balance-trans;
            ATM.history.add(Integer.toString(trans));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+trans+"/- transferred successfully");
            System.out.println("*********************");
        }
        else{
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("***********************");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("**********************");
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        System.out.println("************************");
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
            System.out.println("***********************");
            System.out.println("Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("*********************");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println(" WELCOME TO THE ATM ");
        System.out.println("********************");
        System.out.println("Select any one :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("*******************");
        System.out.println("Enter your choice: ");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("Select from the given options :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM ");
        System.out.println("*********************");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}