import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthTask extends Task {
    public MonthTask(String name, String action, TaskType type, LocalDateTime date, RepeatType repeatType) {
        super(name, action, type, date, repeatType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate) &&
                this.date.toLocalDate().getDayOfMonth() == localDate.getDayOfMonth();
    }
}
