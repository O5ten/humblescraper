import locator.Locator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import predicates.ChildPredicate;
import predicates.ClassPredicate;
import predicates.TextPredicate;
import scraper.Scraper;

import java.util.List;
import java.util.stream.Collectors;

import static matchers.ScraperMatchers.containsElementText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ScraperTest {

    private Scraper scraper;

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Before
    public void before() {
        this.scraper = new Scraper();
    }

    @Test
    public void shouldThrowIfCrawlingOnScraperWithoutDefault() {
        exceptionGrabber.expect(NullPointerException.class);
        this.scraper.scrape();
    }

    @Test
    public void shouldCrawlGoogleAndContainAtLeastOneDiv() {
        assertThat(this.scraper.scrape("http://www.google.se").getAllElements().toString(), containsString("div"));
    }

    @Test
    public void shouldCrawlOnePageAndCollectPricesForCdonWares() {
        Document frontpage = this.scraper.scrape("http://www.gardinstugan.se");
        List<Element> containers = Locator.findElement(frontpage, new ClassPredicate("my_product_holder"), new ChildPredicate(new TextPredicate("cdon")));

        List<String> prices = containers.stream()
                .map(v -> Locator.locateInformationBy(v, new ClassPredicate("my_price")))
                .collect(Collectors.toList());

        assertThat(containers, hasItem(containsElementText("cdon")));
        assertThat(prices, everyItem(containsString(":-")));
    }
}
