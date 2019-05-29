package jankowiak.kamil.currencyModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Query {

    private String from;
    private String to;
    private BigDecimal amount;

    public Query() {
    }

    public Query(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return Objects.equals(from, query.from) &&
                Objects.equals(to, query.to) &&
                Objects.equals(amount, query.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount);
    }

    @Override
    public String toString() {
        return "Query{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
