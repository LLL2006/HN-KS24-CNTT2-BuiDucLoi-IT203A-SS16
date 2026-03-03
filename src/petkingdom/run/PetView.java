package petkingdom.run;

import petkingdom.business.ClientManagement;
import petkingdom.business.PetManagement;
import petkingdom.model.Client;
import petkingdom.model.Pet;
import petkingdom.validator.InputValidate;

import javax.xml.validation.Validator;
import java.util.Scanner;

public class PetView {
    public static void PetMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("""
                    +------------MENU------------+
                    |1. Thêm mới thú cưng        |
                    |2. Hiển thị danh sách       |
                    |3. Tìm kiếm                 |
                    |4. Bán                      |
                    |5. Thoát                    |
                    +----------------------------+
                    """);
            System.out.print("Lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addPet(sc);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    findPet(sc);
                    break;
                case 4:
                    deletePet(sc);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }while(choice != 5);
    }

    public static void addPet(Scanner sc){
        String id;
        String name;
        String type;
//        nhập pet id và kiểm tra hợp lệ
        do {
            System.out.print("Nhập id : ");
            id = InputValidate.getString(sc);
            if(id == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }

        }while(id == null);
//        nhập pet name và kiểm tra hợp lệ
        do {
            System.out.print("Nhập tên : ");
            name = InputValidate.getString(sc);
            if(name == null){
                System.out.println("Tên không hợp lệ!Nhập lại!");
            }

        }while(name == null);
//        nhập pet type và kiểm tra hợp lệ
        do {
            System.out.print("Nhập loài : ");
            type = InputValidate.getString(sc);
            if(type == null){
                System.out.println("Loài không hợp lệ!Nhập lại!");
            }
        }while(type == null);

//        kiểm tra hợp lệ khi thêm dữ liệu
        if(!Main.petManagement.add(new Pet(id,name,type))){
            System.out.println("Id đã tồn tại! Thêm thất bại!");
        }else{
            System.out.println("Thêm thành công!");
        }
    }

    public static void displayAll() {
        if(Main.petManagement.isEmpty()){
            System.out.println("Kho rỗng!");
            return;
        }
        Main.petManagement.displayAll();
    }

    public static void findPet(Scanner sc) {
        if(Main.petManagement.isEmpty()){
            System.out.println("Kho rỗng!");
            return;
        }
        String id;
//        nhập pet id và kiểm tra hợp lệ
        do {
            System.out.print("Nhập id : ");
            id = InputValidate.getString(sc);
            if(id == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(id == null);
//        Tìm pet thông báo nếu như tìm thấy và không tìm thấy
        Pet findPet = Main.petManagement.findById(id);
        if(findPet == null){
            System.out.println("Không tìm thấy thú cưng!");
        }else{
            System.out.println("+----------------------+");
            System.out.printf("|%-5s|%-10s|%-5s|\n","ID","Name","Type");
            System.out.println("+----------------------+");
            System.out.printf(findPet.toString());
            System.out.println("+----------------------+");
        }
    }

    public static void deletePet(Scanner sc) {
        if(Main.petManagement.isEmpty()){
            System.out.println("Kho rỗng!");
            return;
        }
        String petId;
        String userId;
//        nhập pet id và kiểm tra hợp lệ
        do {
            System.out.print("Nhập id thú cưng : ");
            petId = InputValidate.getString(sc);
            if(petId == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(petId == null);

        Pet findPet = Main.petManagement.findById(petId);
        if(findPet == null){
            System.out.println("Không tìm thấy thú cưng!");
            return;
        }
//          Nhập user id và kiểm tra hợp lệ
        do {
            System.out.print("Nhập khách hàng : ");
            userId = InputValidate.getString(sc);
            if(userId == null){
                System.out.println("Id không hợp lệ!Nhập lại!");
            }
        }while(userId == null);

        Client findClient = Main.clientManagement.findById(userId);
        if(findClient == null){
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
//        pet sẽ thêm vào danh sách pet của khách hàng hiện có
        findClient.addPet(findPet);
//        xoá pet khỏi kho
        if(Main.petManagement.delete(petId)){
            System.out.println("Bán thú cưng thành công!");
        }else{
            System.out.println("Không tìm thấy thú cưng!");
        }
    }
}
