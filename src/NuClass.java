import java.util.Scanner;


public class NuClass {
	
	public static double mark_up(String price,String no_people,String category)
	{
		String new_price=price.replace("$","");
		double b_price, b_markup, person_markup, ctg_markup;
		b_price=Double.parseDouble(new_price);
		
		
		b_markup =((b_price*5)/100)+b_price; 	//5% each- Flat Mark up

		//1.2% each- People
		int index_p = no_people.indexOf("p");
		no_people =no_people.substring(0, index_p);
		int price_people = Integer.parseInt(no_people);
		person_markup=((b_markup*price_people*1.2)/100);
		//categories mark up
		if(category.equals("pharmaceuticals") || category.equals("drugs")){ctg_markup=((b_markup*7.5)/100);}
		else if(category.equals("food")){ctg_markup=((b_markup*13)/100);}
		else if(category.equals("electronics")){ctg_markup=((b_markup*2)/100);}
		else{ctg_markup = 0.0;}
		
		double final_amount =  b_markup+person_markup+ctg_markup;
		return final_amount;
	}
	public static void main(String args[])
	{
		
		Scanner a=new Scanner(System.in);
		String b = a.nextLine();
		b=b.replace(" ","");
		b=b.replaceFirst(",","");
		String price = null,person = null,category = null;
		String[] c = b.split(","); 
	    price =c[0];
	    person =c[1];
	    category=c[2];
		double final_price=mark_up(price,person,category);
		System.out.println(" "+final_price);
	}

}
