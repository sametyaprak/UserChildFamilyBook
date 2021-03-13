package springboot.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id:",
        "balance"
})
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountPojo {

    @JsonProperty("id:")
    private long id;
    @JsonProperty("balance")
    private long balance;


    @JsonProperty("id:")
    public long getId() {
        return id;
    }

    @JsonProperty("id:")
    public void setId(long id) {
        this.id = id;
    }


    @JsonProperty("balance")
    public long getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(long balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "BankAccountPojo{" +
                "id='" + id + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}