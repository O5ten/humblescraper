package predicates;

import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ChildPredicate implements Predicate<Element> {

    private List<Predicate<Element>> predicates;
    public ChildPredicate(Predicate<Element>... predicates){
        this.predicates = Arrays.asList(predicates);
    }

    public boolean test(Element element) {
        return element.getAllElements().stream()
                .anyMatch(e -> predicates.stream().allMatch(p -> p.test(e)));
    }
}
