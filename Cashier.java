import java.util.*;

public class Cashier{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String validasi = "";
        int choice = 0;

        int menu_choice = 0
        int nasiAyam = 0, nasi = 0, perkedel = 0; //sebagai flag
        int qty_nasiAyam = 0, qty_nasiAyam = 0, qty_perkedel = 0; //sebagai counter jumlah item
        int subtotal = 0; //sebagai subtotal
        int payment = 0; //sebagai pembayaran dari user
        int change = 0; //sebagai kembalian
        
        do{
	        do{
	            validasi="Y";
	 			System.out.println("*** My Resto ***");
	 			System.out.println("1. Menu");
	 			System.out.println("2. Payment");
	 			System.out.println("3. Exit");
	 			System.out.print(">> Choice :");
	 			try{
	 				choice = in.nextInt();
	 				if(choice < 1 || choice > 3){
	 					validasi = "N";
	 				}
	 			}
	 			catch(Exception e)
	 			{
	 				validasi = "N";
	 				in.nextLine();
	 			}
	 			if (validasi == "N") {
	 				System.out.println("    >> Wrong Input \n");
	 			}
	        }while(validasi == "N");

	        switch(choice)
	        {
	        	case 1 : // menu
	        		do{
	        			validasi = "Y";
			        	System.out.println("# MENU ");
			        	System.out.println("1. Nasi Ayam");
			        	System.out.println("2. Nasi");
			        	System.out.println("3. Perkedel");
			        	try{
			        		menu_choice = in.nextInt();
			        		if(menu_choice < 1 || menu_choice > 3){
	 							validasi = "N";
	 						}
			        	}
			        	catch(Exception e){
			        		validasi = "N";
			        		in.nextLine();
			        	}
			        }while(validasi == "N");

			        switch(menu_choice){
			        	case 1 : //nasi ayam
				        	nasiAyam = 1;
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_nasiAyam = in.nextInt();

					        		if (qty_nasiAyam < 1 || qty_nasiAyam > 10) {
					        			validasi = "N"
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi = "N") {
					        		System.out.println("   >> Wrong Input");
					        	}
				        	}while(validasi == "N");
				        	System.out.println("== You've ordered "+ qty_nasiAyam+ " Nasi Ayam == ");
				        	System.out.println("== Please go to Payment menu to payy the bill ==");
				        	break;

				        case 2 :
				        	nasi = 1;
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_nasi = in.nextInt();

					        		if (qty_nasi < 1 || qty_nasi > 10) {
					        			validasi = "N"
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi = "N") {
					        		System.out.println("   >> Wrong Input");
					        	}
				        	}while(validasi == "N");
				        	System.out.println("== You've ordered "+ qty_nasi+ " Nasi == ");
				        	System.out.println("== Please go to Payment menu to payy the bill ==");
				        	break;

				        case 3 : // nasi
				        	perkedel = 1;
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_perkedel = in.nextInt();

					        		if (qty_perkedel < 1 || qty_perkedel > 10) {
					        			validasi = "N"
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi = "N") {
					        		System.out.println("   >> Wrong Input");
					        	}
				        	}while(validasi == "N");
				        	System.out.println("== You've ordered "+ qty_perkedel+ " Perkedel ==");
				        	System.out.println("== Please go to Payment menu to payy the bill ==");
				        	break;

				        case 4: // break
				        	break;

			        }
		        case 2 : // payment
		        	System.out.println("# PAYMENT ");

		        	if (nasiAyam == 0 && nasi == 0 && perkedel == 0) {
		        		System.out.println("== You didn't order anything yet ==");
		        		System.out.println("== Please go to Menu to Order");
		        		break;
		        	}
		        	int total_nasiAyam = 0, total_nasi = 0, total_perkedel = 0;

		        	if (nasiAyam == 1) {
		        		total_nasiAyam = 13000 * qty_nasiAyam;
		        	}
		        	if (nasi == 1) {
		        		total_nasi = 4000 * qty_nasi;
		        	}
		        	if (perkedel == 1 ) {
		        		total_perkedel = 3000 * qty_perkedel;
		        	}
		        	subtotal = total_nasiAyam + total_nasi + total_perkedel;

		        	System.out.println("== Your orders are : ==");
		        	System.out.println(qty_nasiAyam + " Nasi Ayam \t : Rp. " + total_nasiAyam);
		        	System.out.println(qty_nasi + " Nasii \t : Rp. " + total_nasi);
		        	System.out.println(qty_perkedel + " Perkedel \t : Rp. " + total_perkedel);
		        	System.out.println("== Subtotal : Rp." + subtotal + " ==");

		        	do{
		        		validasi = "Y";
		        		System.out.print("\n\n\nYour Payment : Rp. ");
		        		try{
		        			payment = in.nextInt();
		        			if (payment < subtotal) {
		        				validasi = "N";
		        				System.out.println("   >> Not Enough");
		        			}
		        		}
		        		catch(Exception e){
		        			validasi = "N";
		        			System.out.println("   >> Wrong Input");
		        			in.nextLine();
		        		}
		        	}while(validasi == "N");

		        	if (payment == subtotal) {
		        		System.out.println("==  Payment Success!  ==");
		        		System.out.println("==  Thanks For coming ==");
		        	}
		        	else if (payment > subtotal) {
		        		change = payment - subtotal;
		        		System.out.println("==  Your change : Rp." + change+ "  ==");
		        		System.out.println("==  Payment Success!  ==");
		        		System.out.println("==  Thanks For coming ==");
		        	}
		        	//reseting fields
		        	nasiAyam = 1;
		        	nasi = 1;
		        	perkedel = 1;

		        	break;
		        case 3 : // Exit
		        	System.exit(0);
		        	break;
	        }
	    }while(true)
    }
}