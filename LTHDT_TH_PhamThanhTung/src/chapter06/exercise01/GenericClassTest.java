package chapter06.exercise01;

//import static org.junit.jupiter.api.Assertions.*;

class GenericClassTest {
    public static void main(String[] args) {
        // Tao đối tượng cho GenericClass lưu trữ các số Integer
        GenericClass<Integer> iObj = new GenericClass<Integer>(88);
        iObj.showType();
        // Không cần ép kiểu
        int iVal = iObj.getObj();
        System.out.println("Giá trị: " + iVal);
        // Tạo đối tượng cho GenericClass lưu trữ các chuỗi String.
        GenericClass<String> sObj = new GenericClass<String>("Generics Test");
        sObj.showType();
        String sVal = sObj.getObj();
        System.out.println("Giá trị: " + sVal);
    }
}