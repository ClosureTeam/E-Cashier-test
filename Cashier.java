
import java.util.*;

public class Cashier{
	static Scanner in = new Scanner(System.in);

	static String validasi = "";
	static int menu_choice = 0;
    public static void main(String[] args){
        
        int choice = 0;
        int qty_nasiAyam = 0, qty_nasi = 0, qty_perkedel = 0; //sebagai counter jumlah item
        int subtotal = 0; //sebagai subtotal
        int payment = 0; //sebagai pembayaran dari user
        int change = 0; //sebagai kembalian
        ArrayList<String> list_pilihan = new ArrayList<String>();
        String pesan_lagi ="";
        int qty_1 = 0;
        int qty_2 = 0;
        int qty_3 = 0;

        do{
	        do{
	            validasi="Y";
	 			System.out.println("*** Nasi Padang ***");
	 			System.out.println("1. Menu");
	 			System.out.println("2. Pembayaran");
	 			System.out.println("3. Keluar");
	 			System.out.print(">> Pilih :");
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
	 				System.out.println("    >> Inputan salah \n");
	 			}
	        }while(validasi == "N");

	        switch(choice)
	        {
	        	case 1 : // menu
	        	pilih_menu();
                    do{
			        switch(menu_choice){
			        	case 1 : //nasi ayam
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_nasiAyam = in.nextInt();
				        		    
				        				System.out.print("Apakah mau pesan lagi? [y/n] ");
				        	            pesan_lagi = in.next();
				        	            if(pesan_lagi.equalsIgnoreCase("y")){
				        		           pilih_menu();


				        	            }
                                    qty_1 += qty_nasiAyam;
					        		if (qty_nasiAyam < 1 || qty_nasiAyam > 10) {
					        			validasi = "N";
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi == "N") {
					        		System.out.println("   >> Inputan salah");
					        	}
				        	}while(validasi == "N");
				        	break;

				        case 2 ://nasi
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_nasi = in.nextInt();
				        			System.out.println("Apakah mau pesan lagi?");
				        	            pesan_lagi = in.next();
				        	            if(pesan_lagi.equalsIgnoreCase("y")){
				        		           pilih_menu();
				        	            }

                                    qty_2 += qty_nasi;
					        		if (qty_nasi < 1 || qty_nasi > 10) {
					        			validasi = "N";
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi == "N") {
					        		System.out.println("   >> Inputan salah");
					        	}
				        	}while(validasi == "N");
				        	
				        	break;

				        case 3 : // perkedel
				        	do{
				        		validasi = "Y";
				        		System.out.print(">> Jumlah [1-10] : ");
				        		try{
				        			qty_perkedel = in.nextInt();
				        			System.out.println("Apakah mau pesan lagi?");
				        	            pesan_lagi = in.next();
				        	            if(pesan_lagi.equalsIgnoreCase("y")){
				        		           pilih_menu();
				        	            }

                                    qty_3 += qty_perkedel;
					        		if (qty_perkedel < 1 || qty_perkedel > 10) {
					        			validasi = "N";
					        		}
					        	}catch(Exception e)
					        	{
					        		validasi = "N";
					        		in.nextLine();
					        	}
					        	if (validasi == "N") {
					        		System.out.println("   >> Inputan salah");
					        	}
				        	}while(validasi == "N");
				        	break;

				        case 4: // break
				        	break;

			        }
			    }while(pesan_lagi.equalsIgnoreCase("y"));
		        case 2 : // payment
		        	System.out.println("\n# PEMBAYARAN ");

		        	if (qty_1 < 1 && qty_2 < 1 && qty_3 < 1) {
		        		System.out.println("== Tidak ada makanan yang dipesan ==");
		        		System.out.println("== Silahkan pergi ke menu untuk memesan makanan\n");
		        		break;
		        	}

		        	System.out.println("== Pesanan anda : ==");
		        	if(qty_1 > 0){
				        list_pilihan.add(qty_1 + " Nasi Ayam \t : Rp." + qty_1*13000);
				        subtotal+= qty_1*13000;

		        	}
		        	if(qty_2> 0){
				        list_pilihan.add(qty_2 + " Nasi \t : Rp." + qty_2*4000);
				        subtotal+= qty_2*4000;


		        	}
		        	if(qty_3 > 0){
				        list_pilihan.add(qty_3 + " Nasi Ayam \t : Rp." + qty_3*3000);
				        subtotal+= qty_3*3000;


		        	}

		        	for (String i : list_pilihan) {
                         System.out.println(i);
                    }

		        	do{
		        		validasi = "Y";
		        		System.out.print("\nPembayaran anda \t : Rp.");
		        		try{
		        			payment = in.nextInt();
		        			if (payment < subtotal) {
		        				validasi = "N";
		        				System.out.println("   >> Uang tidak cukup");
		        			}
		        		}
		        		catch(Exception e){
		        			validasi = "N";
		        			System.out.println("   >> Inputan salah");
		        			in.nextLine();
		        		}
		        	}while(validasi == "N");

		        	if (payment == subtotal) {
		        		System.out.println("\n==  Pembayaran sukses!  ==");
		        		System.out.println("==  Terima kasih sudah membeli ==");
		        	}
		        	else if (payment > subtotal) {
		        		change = payment - subtotal;
		        		System.out.println("\n==  kembalian anda  : Rp." + change+ "  ==");
		        		System.out.println("==  Pembayaran sukses!  ==");
		        		System.out.println("==  Terima kasih sudah membeli ==\n");
		        	}

		        	break;
		        case 3 : // Exit
		        	System.exit(0);
		        	break;
	        }
	    }while(true);
    }
    public static void pilih_menu(){
    	do{
	        validasi = "Y";
			System.out.println("\n# MENU ");
			System.out.println("1. Nasi Ayam");
			System.out.println("2. Nasi");
			System.out.println("3. Perkedel");
			System.out.print(">> Pilih :");
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

    }

}