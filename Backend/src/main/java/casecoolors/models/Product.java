package casecoolors.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name="productid")
    private int productid;

    @Column(name="modelname")
    private String modelname;

    @Column(name="casename")
    private String casename;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private float price;

    @Column(name="amount")
    private int amount;

    @Column(name="date")
    private Date manufactureDate;

    @Column(name="image")
    private String image;

    @ManyToOne
    @JoinColumn(name ="brandid")
    Brand brands ;

    @ManyToMany
    @JoinTable(name = "productdetails" , //ชื่อตารางกลางที่แยกออกมา
    joinColumns = @JoinColumn(name ="productid"), //ชื่อ PK คอลัมน์ที่อยู่ในตารางกลาง ของ model นี้
    inverseJoinColumns = @JoinColumn(name = "colorid")) //ชื่อคอลัมน์ PK ของ model ที่จะไป join
    Set<Color> colors ;

}
