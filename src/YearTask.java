import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task {
    public YearTask(String name, String action, TaskType type, LocalDateTime date, RepeatType repeatType) {
        super(name, action, type, date, repeatType);
        this.repeatType = RepeatType.YEAR;
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate) &&
                this.date.toLocalDate().getDayOfYear() == localDate.getDayOfYear();
    }
}
