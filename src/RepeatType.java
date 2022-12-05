import java.time.LocalDate;

public enum RepeatType {
    ONE,
    DAY,
    WEEK,
    MONTH,
    YEAR;
    public boolean appearsIn (LocalDate date, LocalDate receivedDate) {
        switch (this) {
            case ONE -> {
                return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate);
            }
            case DAY -> {
                return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate);
            }
            case WEEK -> {
                return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate) &&
                        this.date.toLocalDate().getDayOfWeek().equals(localDate.getDayOfWeek());
            }
            case MONTH -> {
                return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate) &&
                        this.date.toLocalDate().getDayOfMonth() == localDate.getDayOfMonth();
            }
            case YEAR -> {
                return this.date.toLocalDate().equals(localDate) || this.date.toLocalDate().isBefore(localDate) &&
                        this.date.toLocalDate().getDayOfYear() == localDate.getDayOfYear();
            }
        }
    }
}
