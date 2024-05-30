
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        TreeSet<String> names = new TreeSet<>(Comparator.reverseOrder()); // 이름을 역순으로 정렬하는 TreeSet

        for (int i = 0; i < num; i++) {
            String strRaw = scanner.nextLine();
            String[] strList = strRaw.split(" ");
            String name = strList[0];
            String status = strList[1];

            if(status.equals("leave")
            ){
                names.remove(name);
            }else{
                names.add(name);
            }
        }
        
        for(String name : names)
            System.out.println(name);

        scanner.close();

    }
}
