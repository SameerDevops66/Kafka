package dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {

    private int id;
    private String name;
    private String email;
    private String phone;

}
