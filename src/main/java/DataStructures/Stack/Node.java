package DataStructures.Stack;

import Data.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private City data;
    private Node previous;

    public Node(City city) {
        data = city;
    }
}