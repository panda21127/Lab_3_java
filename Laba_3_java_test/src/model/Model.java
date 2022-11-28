package model;

import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Model {

	protected static String login;
	protected static String password;
	protected static String checkadmin;
	
	public Model(){;
	login="";
	password="";
	checkadmin="";
	try {
        Logging.log( "Model inited");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

	public Model(String loginPerson, String passwordPerson){;
		login=loginPerson;
		password=passwordPerson;
		checkadmin="-";
		try {
            Logging.log( "Model inited");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void SetLogin(String loginPerson)
	{
		login=loginPerson;
	}
	public void Setpassword(String passwordPerson)
	{
		password=passwordPerson;
	}
	public void SetCheckAdmin(String checkadminPerson)
	{
		checkadmin=checkadminPerson;
	}
	public String GetCheckAdmin()
	{
		return checkadmin;
	}
	
	
	public static String AbsoluteFilePath(String nameFile) {
		String fileSeparator=System.getProperty("file.separator");
		String absoluteFilePath = fileSeparator + "H:"+ fileSeparator+"Laba_3_java_test" + fileSeparator+"special_checkers"
		+ fileSeparator + nameFile;
		return absoluteFilePath;
	}	
	
	public static boolean CheckActive() throws IOException {
		return CheckFiles.CheckFile(AbsoluteFilePath("ActivePerson.txt"));
	}
	public static void CreateActive() throws IOException {
		CheckFiles.CreateFile(AbsoluteFilePath("ActivePerson.txt"));
		try {
            Logging.log( "Create Active File");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	public static void WriteActive()
	{
		String[] text= {login+" "+password+" "+checkadmin};
		WriteFile(AbsoluteFilePath("ActivePerson.txt"),text);
		try {
            Logging.log( "Write Active Person");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	public static boolean Checklogin() throws IOException {
		boolean isLogin = false;
		String absoluteFilePath = AbsoluteFilePath("login.txt");
		if (!CheckFiles.CheckFile(absoluteFilePath))
		{
			CheckFiles.CreateFile(absoluteFilePath);
			String[] text= {"admin "+"123 "+"+"};
			WriteFile(absoluteFilePath, text);
		}
		
		BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath));
		try {
			String line;
            while ((line = br.readLine()) != null) {
                String[] logPassAdmin=line.split(" ");
                if (logPassAdmin[0].equals(login))
                {
                	if (logPassAdmin[1].equals(password))
                	{
                		if(logPassAdmin[2].equals("+"))
                		{
                			checkadmin=logPassAdmin[2];
                			WriteActive();
                			isLogin=true;
                			break;
                		}
                		else
                		{
                			checkadmin=logPassAdmin[2];
                			WriteActive();
                			isLogin=true;
                			break;
                		}
                	}
                }
            }
            br.close();
		}
		catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }  
		try {
            Logging.log( "Login input correct"+checkadmin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		return isLogin;
	}
	public static void CreateAccount()
	{
		String[] logPassAdmin= {login+" "+password+" "+checkadmin};
		WriteFile(AbsoluteFilePath("login.txt"),logPassAdmin);
		try {
            Logging.log( "Create account"+logPassAdmin[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	public static void WriteFile(String absoluteFilePath,String[] text)
	{
		
		try(FileWriter writer = new FileWriter(absoluteFilePath, true))
        {
			for (int i=0;i<text.length;i++)
			{
				writer.append(text[i]+"\n");
			}
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
		try {
            Logging.log( "Write in file "+absoluteFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	public static List<String[]> ReadFile(String absoluteFilePath) throws IOException
	{
		FileReader fR = new FileReader(absoluteFilePath);
		BufferedReader br = new BufferedReader(fR);
		List<String[]> text = new ArrayList<>();
		try {
			String line;
            while ((line = br.readLine()) != null) {
                String[] logPassAdmin=line.split(" ");
                text.add(logPassAdmin);
            }
		}
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
		fR.close();
		try {
            Logging.log( "Read in file "+absoluteFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		return text;
	}
	public static String PrintModul()
	{
		if (checkadmin.equals("+"))
			return (login+" root");
		else
			return (login+" user");
	}
}
