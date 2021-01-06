import java.util.*;

public class Cashier{
	static Scanner in = new Scanner(System.in);

	static String validasi = "";
	static int menu_choice = 0;
	static String pesan_lagi ="";
	static String[]arr_menu = {"Nasi Tunjang", "Nasi Ayam Bakar", "Nasi Dadar", "Nasi Ayam Goreng", "Nasi Cincang", "Nasi Rendang", "Nasi Dendeng", "Nasi Kakap", "Nasi Perkedel","Nasi Ikan Bakar"};
    static int[]arr_harga = {21000, 19000, 11000, 19000, 18000, 19000, 18000, 40000, 11000, 19000};
    static int[]arr_qty = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	
    public static void main(String[] args){
        int choice = 0;
        int subtotal = 0; //sebagai subtotal
        int payment = 0; //sebagai pembayaran dari user
        int change = 0; //sebagai kembalian
        ArrayList<String> list_pilihan = new ArrayList<String>();
    

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
			        	case 1 : //Nasi Tunjang
			        	    arr_qty[0] += Cashier.olahMenu();
				        	break;

				        case 2 ://Nasi Ayam Bakar
				        	arr_qty[1] += Cashier.olahMenu();
				        	break;

				        case 3 : //Nasi Dadar
				        	arr_qty[2] += Cashier.olahMenu();
				        	break;

				        case 4: //Nasi Ayam Goreng
				            arr_qty[3] += Cashier.olahMenu();
				        	break;

				        case 5 : //Nasi Cincang
			        	    arr_qty[4] += Cashier.olahMenu();
				        	break;

				        case 6 ://Nasi Rendang
				        	arr_qty[5] += Cashier.olahMenu();
				        	break;

				        case 7 : //Nasi Dendeng
				        	arr_qty[6] += Cashier.olahMenu();
				        	break;

				        case 8: //Nasi Kakap
				            arr_qty[7] += Cashier.olahMenu();
				        	break;

				        case 9 : //Nasi Perkedel
			        	    arr_qty[8] += Cashier.olahMenu();
				        	break;

				        case 10 ://Nasi Ikan Bakar
				        	arr_qty[9] += Cashier.olahMenu();
				        	break;

				      

			        }
			    }while(pesan_lagi.equalsIgnoreCase("y"));
		        case 2 : // payment
		        	System.out.println("\n# PEMBAYARAN ");

		        	if (arr_qty[0] < 1 && arr_qty[1] < 1 && arr_qty[2] < 1 && arr_qty[3] < 1 && arr_qty[4] < 1 &&
		        	    arr_qty[5] < 1 && arr_qty[6] < 1 && arr_qty[7] < 1 && arr_qty[8] < 1 && arr_qty[9] < 1) {
		        		System.out.println("== Tidak ada makanan yang dipesan ==");
		        		System.out.println("== Silahkan pergi ke menu untuk memesan makanan\n");
		        		break;
		        	}

		        	System.out.println("== Pesanan anda : ==");

		        	for (int i = 0;i < arr_qty.length ;i++ ) {
		        		if(arr_qty[i] > 0){
				        list_pilihan.add(arr_qty[i] +" "+arr_menu[i]+"  : Rp." + arr_qty[i]*arr_harga[i]);
				        subtotal+= arr_qty[i]*arr_harga[i];
		        	    }
		        	}

		        	list_pilihan.add("Total Pembayaran: Rp. "+subtotal);

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
		        		System.exit(0);
		        	}
		        	else if (payment > subtotal) {
		        		change = payment - subtotal;
		        		System.out.println("\n==  kembalian anda  : Rp." + change+ "  ==");
		        		System.out.println("==  Pembayaran sukses!  ==");
		        		System.out.println("==  Terima kasih sudah membeli ==\n");
		        		System.exit(0);

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
			for (int i = 0;i < arr_menu.length ;i++ ) {
				System.out.println((i+1)+". "+arr_menu[i]+": Rp."+arr_harga[i]);
			}
			System.out.print(">> Pilih :");
			    try{
			        menu_choice = in.nextInt();
			        if(menu_choice < 1 || menu_choice > arr_menu.length){
	 					validasi = "N";
	 				}
	 				if (validasi == "N") {
					    System.out.println("   >> Inputan salah");
					    }
			    }
			    catch(Exception e){
			        validasi = "N";
			        in.nextLine();
			        }
		}while(validasi == "N");
    }


    public static int olahMenu(){
    	int y = 0;
    	int x = 0;
		do{
			validasi = "Y";
			System.out.print(">> Jumlah [1-10] : ");
				try{
				    x = in.nextInt();
				    if (x < 1 || x > 10) {
					    validasi = "N";
					}
					else{
					     do{
				        	System.out.print("Apakah mau pesan lagi? [y/n] ");
				        	pesan_lagi = in.next();
				        	if(pesan_lagi.equalsIgnoreCase("y")){
				        		pilih_menu();
				        	}else if(pesan_lagi.equalsIgnoreCase("n")){
				        	    validasi = "Y";
				        	}else{
				        	    validasi = "N";
				        	}
				        	if (validasi == "N") {
					            System.out.println("   >> Inputan salah");
					        }

				        }while(validasi == "N");

                        y += x;
					}
					
					if (validasi == "N") {
					    System.out.println("   >> Inputan salah");
					    }
				        		    
				}catch(Exception e)
					        	{
					        	 validasi = "N";
					        	 in.nextLine();
					        	 }
					        	
		}while(validasi == "N");
                   
        return y;
    }
}