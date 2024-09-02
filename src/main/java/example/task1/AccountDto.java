package example.task1;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private int accnum;
    private String accexp;
    private int accmoney;
    private String accdate;

}
