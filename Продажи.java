import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 20);
        Map<String, Map<String, Long>> sales = new TreeMap<>(String::compareTo);
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            int firstSpace = line.indexOf(' ');
            if (firstSpace <= 0) continue;
            
            int secondSpace = line.indexOf(' ', firstSpace + 1);
            if (secondSpace <= firstSpace) continue;
            
            try {
                String customer = line.substring(0, firstSpace);
                String product = line.substring(firstSpace + 1, secondSpace);
                long quantity = Long.parseLong(line.substring(secondSpace + 1));
                
                Map<String, Long> products = sales.computeIfAbsent(customer, 
                    k -> new TreeMap<>(String::compareTo));
                products.merge(product, quantity, Long::sum);
            } catch (NumberFormatException e) {
                continue;
            }
        }

        for (Map.Entry<String, Map<String, Long>> customer : sales.entrySet()) {
            output.append(customer.getKey()).append(":\n");
            for (Map.Entry<String, Long> product : customer.getValue().entrySet()) {
                output.append(product.getKey()).append(' ')
                      .append(product.getValue()).append('\n');
            }
        }
        System.out.print(output);
    }
}
