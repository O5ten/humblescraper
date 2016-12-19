package predicates;

import org.jsoup.nodes.Element;

import java.util.function.Predicate;

public class ClassPredicate implements Predicate<Element> {

    private String className;

    public ClassPredicate(String className){
        this.className = className;
    }
    public boolean test(Element element) {
        return element.classNames().contains(this.className);
    }
}
