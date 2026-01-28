import java.util.ArrayList;
import java.util.Scanner;

public class WiseSaying {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<String> wise = new ArrayList<>();
        ArrayList<String> auth = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();//입력받고 다음줄로 넘겨버림
            if (command.equals("종료")) {
                System.exit(0);
            }
            if (command.equals("등록")) {//==는 숫자를 비교할때 쓰도록 하자. 문자열은 equals()로
                System.out.print("명언 : ");
                String say = sc.nextLine();
                wise.add(say);
                System.out.print("작가 : ");
                String author = sc.nextLine();
                auth.add(author);
                n++;
                number.add(n);
                System.out.println(n + "번 명언이 등록 되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = auth.size()-1; i>=0;i--){
                    System.out.println(number.get(i)+" / "+auth.get(i)+" / "+wise.get(i));
                }
            }else if(command.startsWith("삭제?id=")){
                String[] parts = command.split("=");
                int idDelete = Integer.parseInt(parts[1]);

                int Delete=-1;
                for(int i=0;i<number.size();i++){
                    if(number.get(i)==idDelete){
                        Delete=i;
                        break;
                    }
                }
                if(Delete != -1){
                    number.remove(Delete);
                    wise.remove(Delete);
                    auth.remove(Delete);
                    System.out.println(Delete+"번 명언이 삭제되었습니다.");
                }else{
                    System.out.println(idDelete+"번 명언은 존재하지 않습니다.");
                }

            }else if(command.startsWith("수정?id=")){
                String[] parts = command.split("=");
                int idModify = Integer.parseInt(parts[1]);

                int Modify =-1;
                for(int i=0;i<number.size();i++){
                    if(number.get(i)== idModify){
                        Modify =i;
                        break;
                    }
                }
                if(Modify != -1){
                    System.out.println("명언(기존) : "+wise.get(Modify));
                    System.out.print("명언 : ");
                    String new_wise = sc.nextLine();
                    wise.set(Modify,new_wise);
                    System.out.println("명언(기존) : "+auth.get(Modify));
                    System.out.print("명언 : ");
                    String new_auth = sc.nextLine();
                    auth.set(Modify, new_auth);
                    System.out.println(Modify+"번 명언이 수정되었습니다.");
                }else{
                    System.out.println(idModify+"번 명언은 존재하지 않습니다.");
                }
            }
        }

    }
}
