import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTask extends Task {
    public OneTask(String name, String action, TaskType type, LocalDateTime date, RepeatType repeatType) {
        super(name, action, type, date, repeatType);
        this.repeatType = RepeatType.ONE;
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate);
    }
}
