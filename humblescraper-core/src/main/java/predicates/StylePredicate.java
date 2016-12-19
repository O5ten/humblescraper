package predicates;

import org.jsoup.nodes.Element;

import java.util.function.Predicate;

public class StylePredicate implements Predicate<Element> {

    private String styleKey;
    private String styleValue;

    public StylePredicate(String styleKey, String styleValue){
        this.styleKey = styleKey;
        this.styleValue = styleValue;
    }
    public boolean test(Element element) {
        return element.get.contains(this.className);
    }
}
