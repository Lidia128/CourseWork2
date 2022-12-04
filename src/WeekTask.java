import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeekTask extends Task{
    public WeekTask(String name, String action, TaskType type, LocalDateTime date, RepeatType repeatType) {
        super(name, action, type, date, repeatType);
        this.repeatType = RepeatType.WEEK;
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return this.date.toLocalDate().equals(localDate)||this.date.toLocalDate().isBefore(localDate)&&
                this.date.toLocalDate().getDayOfWeek().equals(localDate.getDayOfWeek());
    }
}
