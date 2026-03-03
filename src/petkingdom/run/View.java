package petkingdom.run;

import petkingdom.business.PetManagement;

import java.util.Scanner;

public class View {
    public static void showMenu(Scanner sc){
        int choice;
        do {

            System.out.println("""
                    +------------MENU------------+
                    |1. Quản lý kho thú cưng     |
                    |2. Quản lý khách hàng       |
                    |3. Quản lý dịch vụ Spa      |
                    |4. Thoát                    |
                    +----------------------------+
                    """);
            System.out.print("Lựa chọn của bạn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    PetView.PetMenu(sc);
                    break;
                case 2:
                    ClientView.ClientMenu(sc);
                    break;
                case 3:
                    ServiceView.ServiceMenu(sc);
                    break;
                default:
                    break;
            }
        }while(choice != 4);

    }
}
