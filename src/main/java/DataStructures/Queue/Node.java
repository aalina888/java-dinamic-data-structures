package DataStructures.Queue;

import Data.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Node {
    private City data;
    private Node next;

    public Node(City city) {
        data = city;
    }
}
