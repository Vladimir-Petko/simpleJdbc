import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String id;

    private String name;

    private String description;

    private LocalDate date;
}
