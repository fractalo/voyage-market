package voyage.market.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String username;

    private String title;

    private String content;

    private Integer price;

    public Item(String username, String title, String content, Integer price) {
        this.update(username, title, content, price);
    }

    public void update(String username, String title, String content, Integer price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
