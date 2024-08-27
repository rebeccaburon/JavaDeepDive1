package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e2Collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1, 100.0, "USD"),
                new Transaction(2, 150.0, "EUR"),
                new Transaction(3, 200.0, "USD"),
                new Transaction(4, 75.0, "GBP"),
                new Transaction(5, 120.0, "EUR"),
                new Transaction(6, 300.0, "GBP")
        );

        // Calculate the total sum of all transaction amounts
        double totalSum = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
       System.out.println("Total sum of all transactions: " + totalSum);

        // Group transactions by currency and calculate sum for each currency
        Map<String, Double> sumByCurrency = transactions.stream()
                //groups the transactions by their currency:
                .collect(Collectors.groupingBy(Transaction::getCurrency,
                        // sums the amounts of the transactions in each group.
                        Collectors.summingDouble(Transaction::getAmount)));
       System.out.println("Sum of transactions by currency: " + sumByCurrency);

        // Find the highest transaction amount
        Transaction highestTransaction = transactions.stream()

                //with a custom comparator finds the transaction with the highest amount:
                // t1 and t2 are placeholder variable names for the two Transaction objects that
                // are being compared in each iteration of the stream processing.
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))

                //ensures that an exception is thrown if no transactions are found:
                .orElseThrow(() -> new RuntimeException("No transactions available"));
        System.out.println("Highest transaction amount: " + highestTransaction.getAmount());

        // Find the average transaction amount
        double averageAmount = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));
        System.out.println("Average transaction amount: " + averageAmount);
    }
}
