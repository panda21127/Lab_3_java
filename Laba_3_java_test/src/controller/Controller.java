package controller;
import java.util.Scanner;

public class Controller {
	public static Scanner scanner=new Scanner(System.in);
	
	public static String inputString() {
		return scanner.nextLine();
	}
	protected static  boolean CheckInt(String line)
	{
			try 
			{
				int intValue=Integer.parseInt(line);
				return true;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Input incorrect");
				return false;
			}
	}
	public static int CheckIntput()
	{
		String line=scanner.nextLine();
		boolean flag=CheckInt(line);
		while(flag==false)
		{
			line=scanner.nextLine();
			flag=CheckInt(line);
		}
		return Integer.parseInt(line);
	}
	public static int CheckPositiv()
	{
		int number=CheckIntput();
		while(number<1)
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}
	public static int CheckPositivKind()
	{
		int number=CheckIntput();
		while((number<1)||(number>4))
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}

	public static String InputLogin()
	{
		System.out.println("Enter login: ");
		String login=inputString();
		return login;
	}
	public static String InputPassword()
	{
		System.out.println("Enter password: ");
		String password=inputString();
		return password;
	}
	
	public static int CheckChoice(int left,int right)
	{
		int number=CheckIntput();
		while((number<left)||(number>right))
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}
}

