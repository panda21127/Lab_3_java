package model.animal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.Controller;

public class ModelAnimal extends KindAnimals {
//	KindAnimals animal=new KindAnimals();
	
	public ModelAnimal()
	{
		super();
	}
	public ModelAnimal(String Name,int Weight,int Age,int KindAnimal)
	{
		super(Name,Weight,Age,KindAnimal);
	}
	
 	public static ModelAnimal modelAnimal() {
		System.out.println("\nInput animal: ");
		System.out.println("Name: ");
		String name=Controller.inputString();
		System.out.println("Kind Animal: ");
		System.out.println("1.Waterfowl\n2.Feathered\n3.Ungulates\n4.Cold-blooded ");
		System.out.println("Please input number: ");
		int kindAnimal=Controller.CheckPositivKind();
		System.out.println("Weight: ");
		System.out.println("Please input number: ");
		int Weight=Controller.CheckPositiv();
		System.out.println("Age: ");
		System.out.println("Please input number: ");
		int Age=Controller.CheckPositiv();
		ModelAnimal animal=new ModelAnimal(name,Weight,Age,kindAnimal);
		return animal;
		
	}
	public static void PrintInfArray(List<ModelAnimal> text) {
		System.out.println("\nName:\tKind Animal:\tWeight:\tAge: ");
		for(int i=0;i<text.size();i++)
		{
			text.get(i).PrintInf();
			text.get(i).move(text.get(i).GetKindAnimal());
			System.out.println();
		}
	}
	public static List<ModelAnimal> ReadFile(String absoluteFilePath) throws IOException
	{
		FileReader fR = new FileReader(absoluteFilePath);
		BufferedReader br = new BufferedReader(fR);
		List<ModelAnimal> text = new ArrayList<>();
		try {
			String line;
            while ((line = br.readLine()) != null) {
            	String[] array=line.split(" ");
            	ModelAnimal logPassAdmin=new ModelAnimal(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]));
                text.add(logPassAdmin);
            }
		}
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
		fR.close();
		return text;
	}
	public static void WriteFile(String absoluteFilePath,List<ModelAnimal> text)
	{
		
		try(FileWriter writer = new FileWriter(absoluteFilePath, false))
        {
			for (int i=0;i<text.size();i++)
			{
				writer.append(text.get(i).Print()+"\n");
			}
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
}
