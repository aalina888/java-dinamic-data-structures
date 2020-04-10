package DataStructures.LinkedList;

import Data.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public
class Node {
    private City data;
    private Node next;

    public Node(City city) {
        data = city;
    }
}
