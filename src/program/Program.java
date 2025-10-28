package program;
import java.util.Scanner;
public class Program{
    private final static String TEXT_MENU = """
Выберите операцию и введите её номер:
1   - Добавить новый доход.
2   - Добавить новый расход.
3   - Выбрать систему налогооблажения.
end - Выход.
>""";
    private final static String TEXT_RUB = " рублей.\n";
    private final static Scanner scanner = new Scanner(System.in);
    private static int earnings = 0;
    private static int spendings = 0;
    private static int minusEqualsZero(int number){
        return number > -1 ? number : 0;
    }
    private static int taxEarnings(int earnings){
        return (int)(6 * earnings / 100);
    }
    private static int taxEarningsMinusSpendings(int earnings, int spendings){
        return minusEqualsZero(15 * (earnings - spendings) / 100);
    }
    private static int economy(int taxEarningsMinusSpendings, int taxEarnings){
        return minusEqualsZero(taxEarningsMinusSpendings - taxEarnings);
    }
    public static byte menu(){
        System.out.print(TEXT_MENU);
        String input = scanner.nextLine();
        switch(input){
            case"1":{
                System.out.print("Введите сумму дохода:\n>");
                earnings += Integer.parseInt(scanner.nextLine());
                System.out.print("\n");
            }return 1;
            case"2":{
                System.out.print("Введите сумму расхода:\n>");
                spendings += Integer.parseInt(scanner.nextLine());
                System.out.print("\n");
            }return 1;
            case"3":{
                System.out.print("\nМы советуем вам УСН доходы.\n");
                int taxE = taxEarnings(earnings);
                System.out.print("Ваш налог состави: " + taxE + TEXT_RUB);
                int taxEMS = taxEarningsMinusSpendings(earnings, spendings);
                System.out.print("Налог на другой системе: " + taxEMS + TEXT_RUB);
                System.out.print("Экономия: " + economy(taxEMS, taxE) + TEXT_RUB + "\n");
            }return 1;
            case"end":{
                System.out.print("Программа завершена!");
            }return 0;
            default:{
                System.out.print("Такой операции нет!\n");
            }return 2;
        }
    }
}