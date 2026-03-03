package petkingdom.run;

import petkingdom.business.ClientManagement;
import petkingdom.model.Client;
import petkingdom.validator.InputValidate;

import java.util.Scanner;

public class ClientView {
    public static void ClientMenu(Scanner sc){
        int choice;
        do {
            System.out.println("""
                    +------------MENU------------+
                    |1. Đăng ký thành viên       |
                    |2. Tra cứu nhanh            |
                    |3. Thoát                    |
                    +----------------------------+
                    """);
            System.out.print("Lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    searchClient(sc);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }while(choice != 3);
    }

    public static void register(Scanner sc){
        String id;
        do {
            System.out.print("Nhập id : ");
            id = InputValidate.getString(sc);
            if(id == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(id == null);
        String name;
        do {
            System.out.print("Nhập tên : ");
            name = sc.nextLine();
            if(name == null){
                System.out.println("Tên không hợp lệ!Nhập lại!");
            }
        }while(name == null);

        String phoneNumber;
        do {
            System.out.print("Nhập số điện thoại : ");
            phoneNumber = sc.nextLine();
            if(phoneNumber == null){
                System.out.println("Số điện thoại không hợp lệ!Nhập lại!");
            }
        }while(phoneNumber == null);

        if(!Main.clientManagement.add(new Client(id, name,phoneNumber))){
            System.out.println("Id hoặc số điện thoại đã tồn tại! Đăng ký thất bại");
        }else{
            System.out.println("Đăng ký thành công!");
        }
    }

    public static void searchClient(Scanner sc){
        if(ClientManagement.isEmpty()){
            System.out.println("Danh sách khách hàng rỗng!");
            return;
        }
        String id;
        do {
            System.out.print("Nhập id : ");
            id = InputValidate.getString(sc);
            if(id == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(id == null);

        Client findClient = Main.clientManagement.findById(id);
        if(findClient == null){
            System.out.println("Khách hàng không tồn tại!");
        }else{
            ClientManagement.displayClient(findClient);
        }
    }
}
