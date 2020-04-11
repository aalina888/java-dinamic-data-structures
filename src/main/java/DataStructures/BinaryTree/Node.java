package DataStructures.BinaryTree;

import Data.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    private City data;

    private Node more;
    private Node less;

    public Node(City city) {
        data = city;
    }
}
