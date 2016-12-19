package predicates;

import org.jsoup.nodes.Element;

import java.util.function.Predicate;

public class TextPredicate implements Predicate<Element> {

    private String text;

    public TextPredicate(String text){
        this.text = text;
    }

    public boolean test(Element element) {
        return element.text().toLowerCase().contains(this.text.toLowerCase());
    }
}
