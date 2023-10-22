package streams;

import Domain.Trader;
import Domain.Transaction;
import com.sun.source.tree.UsesTree;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TraderStreamProcessor {
    public Trader trader;

    public List<Transaction> transactionList;

    //1 Find all transactions in the year 2011 and sort them by value (small to high).
    public void findAll(List<Transaction> transactionList) {
        transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    //What are all the unique cities where the traders work?
    public void uniqueCities(List<Transaction> transactionList) {
        transactionList.stream()
                .map(tr -> tr.getTrader().getCity())
                //.distinct() could also drop distinct() and use toSet() instead
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    //Finds all traders from Cambridge and sort them by name
    public void findCambridgeTraders(List<Transaction> transactionList) {
        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(tr -> Objects.equals(tr.getCity(), "Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName)).forEach(System.out::println);
    }

    //Returns a string of all traders’ names sorted alphabetically
    public String findAllSortedTraders(List<Transaction> transactionList) {
        return transactionList.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
//                .reduce("", (n1,n2)->n1+n2);
                .collect(Collectors.joining());
    }

    //Are any traders based in Milan?
    public boolean findAnyTraderInMilan(List<Transaction> transactionList) {
        return transactionList.stream()
                .anyMatch(tr->tr.getTrader().getCity().equals("Milan"));
    }

    //Prints all transactions’ values from the traders living in Cambridge
    public void cambridgeTransactionValue(List<Transaction> transactionList) {
          transactionList.stream()
                  .filter(tr->tr.getTrader().getCity().equals("Cambridge"))
//                  .map(tr->tr.getTrader().getCity().equals("Cambridge"))
                  .map(Transaction::getValue)
                  .forEach(System.out::println);
    }

    //What’s the highest value of all the transactions
    public Optional<Integer> findHighestValue(List<Transaction> transactionList) {
        return transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }
    //Finds the transaction with the smallest value
    public Optional<Transaction> findSmallestValue(List<Transaction> transactionList){
        return transactionList.stream()
//                .reduce((t1,t2)-> t1.getValue()<t2.getValue()?t1:t2);
                .min(comparing(Transaction::getValue));
    }
    }
