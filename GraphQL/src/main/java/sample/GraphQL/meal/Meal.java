package sample.GraphQL.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Meal{
    public String id;
    public String name;
    public String quantity;
    public String taste;
    public Nutriation nutriation;
}
