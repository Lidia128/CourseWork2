import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    private final static DateTimeFormatter TASK_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm");
    private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final static Service<Task> service = new Service<>();
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printInfo();
                System.out.print("Выберите пункт: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    scanner.reset();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            System.out.print("Введите задачу, которую хотите удалить: ");
                            String taskName = scanner.next();
                            service.removeTask(taskName);
                            break;
                        case 3:
                            System.out.print("Введите дату на которую хотите получить список задач: ");
                            LocalDate date = LocalDate.parse(scanner.next(), FORMAT);
                            System.out.println(service.getTasksForDay(LocalDate.from(date)));
                            break;
                        case 4:
                            service.printTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите задачу");
                }
            }
        }
        printInfo();
    }
    private static void inputTask(Scanner scanner) {
        String taskName = readString("Введите название задачи", scanner);
        System.out.print("Введите кратность задачи: ");
        RepeatType repeatType = readTaskRepeatType(scanner);
        String action = readString("Опишите задачу", scanner);
        LocalDateTime date = readTaskDate(scanner);
        System.out.print("Введите вид задачи: ");
        TaskType type = readTaskType(scanner);
        switch (repeatType) {
            case ONE:
                service.addTask(new OneTask(taskName, action, type, date, repeatType));
                break;
            case DAY:
                service.addTask(new DayTask(taskName, action, type, date, repeatType));
                break;
            case WEEK:
                service.addTask(new WeekTask(taskName, action, type, date, repeatType));
                break;
            case MONTH:
                service.addTask(new MonthTask(taskName, action, type, date, repeatType));
                break;
            case YEAR:
                service.addTask(new YearTask(taskName, action, type, date, repeatType));
                break;
        }
    }
    private static void printInfo() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанную дату
                        4. Получить список всех задач
                        0. Выход
                        """
        );
    }
    public static TaskType readTaskType(Scanner scanner) {
        System.out.println("Выберите вид задачи\n1. Личная \n2. Рабочая");
        while (true) {
            try {
                System.out.println("Введите вид задачи:");
                int taskTypeSelector = scanner.nextInt();
                switch (taskTypeSelector) {
                    case 1:
                        return TaskType.PERSONAL;
                    case 2:
                        return TaskType.WORKER;
                    default:
                        System.out.println("Неверный вид задачи");
                }
            } catch (Exception e) {
                System.out.println("Неправильный вид задачи");
            }
        }
    }
    public static RepeatType readTaskRepeatType(Scanner scanner) {
        System.out.println("Кратность задачи\n1. Один раз \n2. Ежедневно \n3. Еженедельно \n4. Ежемесячно \n5. Ежегодно");
        while (true) {
            try {
                System.out.println("Введите вид задачи:");
                int taskRepeatTypeSelector = scanner.nextInt();
                switch (taskRepeatTypeSelector) {
                    case 1:
                        return RepeatType.ONE;
                    case 2:
                        return RepeatType.DAY;
                    case 3:
                        return RepeatType.WEEK;
                    case 4:
                        return RepeatType.MONTH;
                    case 5:
                        return RepeatType.YEAR;
                    default:
                        System.out.println("Не верный вид задачи");
                }
            } catch (Exception e) {
                System.out.println("Не верный вид задачи");
            }
        }
    }
    public static LocalDateTime readTaskDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату и время задачи в формате дд.мм.гггг чч.мм:");
                String dateTimeToken = scanner.nextLine();
                return LocalDateTime.parse(dateTimeToken, TASK_DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Дата или время введены не верно");
            }
        }
    }
    public static String readString(String message, Scanner scanner) {
        while (true) {
            try {
                System.out.println(message);
                String string = scanner.nextLine();
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Заполните поле");
            }
        }
    }
}
