package petkingdom.run;

import petkingdom.business.ClientManagement;
import petkingdom.business.PetManagement;
import petkingdom.model.Client;
import petkingdom.model.Pet;
import petkingdom.validator.InputValidate;

import java.util.Scanner;

public class ServiceView {
    public static void ServiceMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("""
                    +------------MENU------------+
                    |1. Tiếp nhận thú cưng       |
                    |2. Xử lý dịch vụ            |
                    |3. Thoát                    |
                    +----------------------------+
                    """);
            System.out.print("Lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    serviceAdopted(sc);
                    break;
                case 2:
                    serviceProgress();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }while(choice != 3);
    }

    public static void serviceAdopted(Scanner sc) {
//        Nhập user id và kiểm tra hợp lệ
        String userId;
        do {
            System.out.print("Nhập id khách hàng : ");
            userId = InputValidate.getString(sc);
            if(userId == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }

        }while(userId == null);

        Client findClient = Main.clientManagement.findById(userId);
        if(findClient == null){
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
//        Nhập pet id và kiểm tra hợp lệ
        String petId;
        do {
            System.out.print("Nhập id thú cưng : ");
            petId = InputValidate.getString(sc);
            if(petId == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(petId == null);

        Pet findPet = findClient.findPetById(petId);
        if(findPet == null){
            System.out.println("Không tìm thấy thú cưng!");
            return;
        }
//        gọi hàm xử lý
        Main.serviceManagement.petAdoption(findPet);
    }

    public static void serviceProgress(){
        Main.serviceManagement.serviceProcessing();
    }
}
