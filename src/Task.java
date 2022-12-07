import java.time.LocalDate;
import java.time.LocalDateTime;

abstract class Task implements Repeatable {
    private String name;
    private String action;
    private final int id;
    private static int counter = 1;
    protected TaskType type;
    protected LocalDateTime date;
    protected RepeatType repeatType;

    public Task(String name, String action, TaskType type, LocalDateTime date, RepeatType repeatType) {
        this.name = name;
        this.action = action;
        this.id = counter++;
        this.type = type;
        this.date = date;
        this.repeatType = repeatType;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Задача: " + name + ", описание: " + action + ", id=" + id +
                ", тип задачи: " + type + ", дата выполнения" + date +
                ", повторяемость" + repeatType;
    }
}



