package excercises.datecalc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class MyController {

    @GetMapping("/")
    @ResponseBody
    public String index(@RequestParam int year, int month, int day){
        LocalDate input = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();

        if (input.isAfter(now)) {
            int daysLeft = (int) now.until(input, ChronoUnit.DAYS);
            return "There are " + daysLeft + " days left to that date.";
        } else if (input.isBefore(now)){
            int daysPassed = (int) input.until(now, ChronoUnit.DAYS);
            return "" + daysPassed + " days have passed since the entered date.";
        } else {
            return " You have entered today's date";
        }
    }
}
