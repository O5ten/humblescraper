package locator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Locator {

    public static List<Element> findElement(Document page, Predicate<Element>... predicateCollection) {
        return page.getAllElements().stream()
                .filter(e -> Arrays.asList(predicateCollection).stream().allMatch(p -> p.test(e)))
                .collect(Collectors.<Element>toList());

    }

    public static String locateInformationBy(Element element, Predicate<Element>... predicateCollection) {
        return element.getAllElements().stream()
                .filter(e -> Arrays.asList(predicateCollection).stream().allMatch(p -> p.test(e)))
                .findFirst().get().text();
    }
}
