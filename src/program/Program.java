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
    private final static byte INCOME = 6;
    private final static byte DIFFERENCE_INCOME_EXPENSES = 15;
    private final static Scanner scanner = new Scanner(System.in);
    private static int earnings = 0;
    private static int spendings = 0;
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
                int tax0 = INCOME * earnings / 100;
                System.out.print("Ваш налог состави: " + tax0 + TEXT_RUB);
                int tax1 = DIFFERENCE_INCOME_EXPENSES * (earnings - spendings) / 100;
                System.out.print("Налог на другой системе: " + tax1 + TEXT_RUB);
                int economy = tax1 - tax0;
                System.out.print("Экономия: " + (economy > -1 ? economy : 0) + TEXT_RUB + "\n");
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