import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isDivid3 = i % 3 == 0;
            boolean isDivid5 = i % 5 == 0;
            StringBuffer sb = new StringBuffer();
            if (isDivid3) sb.append("Fizz");
            if (isDivid5) sb.append("Buzz");
            if (sb.length() == 0) {
                res.add(String.valueOf(i));
            } else {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
