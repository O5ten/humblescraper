package matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.jsoup.nodes.Element;

public class ElementTextMatcher extends BaseMatcher<Element>{

    private String text;
    public ElementTextMatcher(String text){
        this.text = text;
    }

    @Override
    public boolean matches(Object o) {
        Element element = null;
        if(o instanceof Element){
            element = (Element) o;
            return element.text().toLowerCase().contains(this.text.trim().toLowerCase());
        }else{
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {

    }
}
