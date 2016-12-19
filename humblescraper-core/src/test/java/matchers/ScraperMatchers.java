package matchers;

public class ScraperMatchers {
    public static ElementTextMatcher containsElementText(String text){
        return new ElementTextMatcher(text);
    }
}
