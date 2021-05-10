package casecoolors.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "colors")
@NoArgsConstructor
@AllArgsConstructor
//@SQLInsert(sql = "insert ignore into color(colorId,colorName,colorCode) values (?,?,?)")
//@JsonIgnoreProperties(value ="products")
public class Color {
    @Id
    private int colorId;
    private String colorName;
    private String colorCode;

}
