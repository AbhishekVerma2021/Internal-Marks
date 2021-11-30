import java.sql.*;
import java.util.Scanner;
class InvalidEntry extends Exception
{
        public InvalidEntry(String str)
        {
            super(str);
        }
}
public class Info01
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException,InvalidEntry
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root"," ");
        Statement S= con.createStatement();
        Scanner sc=new Scanner(System.in);
        String Name=sc.next();
        String Phone=sc.next();
        if(Phone.length()>10 || Phone.length()<10)
        {
            throw new InvalidEntry("Invalid Entry!!!!")
        }
        else
        {
            ResultSet r=S.executeQuery("insert into info values (Name,Phone)");
            System.out.println(r.getString("Name")+ " " + r.getString("Phone No."));
        }
        con.close();
    }
}
