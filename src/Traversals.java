import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);


    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children = new ArrayList<>();
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children = new ArrayList<>();
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children = new ArrayList<>();
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children = new ArrayList<>();
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);

    // preOrder(root);

    Map<Integer, List<Integer>> parentToChild = new HashMap<>();
    parentToChild.put(88, List.of(17, 58, 33));
    parentToChild.put(24, List.of(83, 6));
    parentToChild.put(58, List.of(73));
    parentToChild.put(33, List.of(24, 61, 12));
    parentToChild.put(12, List.of());
    parentToChild.put(5, List.of());
    parentToChild.put(99, List.of());
    parentToChild.put(61, List.of());
    parentToChild.put(83, List.of());
    parentToChild.put(73, List.of());
    parentToChild.put(6, List.of());
    parentToChild.put(17, List.of(5, 99));

    preOrderMap(parentToChild, 88);
  }

  public static void preOrderMap(Map<Integer, List<Integer>> parentToChild, int current) {
    // Base case:
    // map is null or current not in map return
    // print current 
    // children = parentToChild.get(current)
    // for each child in children
    //     recurse on child
    if (parentToChild == null || !parentToChild.containsKey(current)) return;
    System.out.println(current);
    List<Integer> children = parentToChild.get(current);

    for (int child : children) {
      preOrderMap(parentToChild, child);
    }
  }

  public static <T> void preOrder(Node<T> node) {
    // Base case:
    // if node is null return
    // print node value
    // if no children return 
    // for each child in node's children
    //     recurse on the child
    if (node == null) return;

    System.out.println(node.value);

    // if (node.children == null) return;

    for (var child : node.children) {
      preOrder(child);
    }
  }
}
