import java.time.LocalDate;

public class Holiday {

    private LocalDate start;
    private LocalDate end;
    private int year;
    private String stateCode;
    private String name;
    private String slug;

    public Holiday(LocalDate start, LocalDate end, int year, String stateCode, String name, String slug){
        this.start=start;
        this.end=end;
        this.year=year;
        this.stateCode=stateCode;
        this.name=name;
        this.slug=slug;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getSlug() {
        return slug;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }
}
