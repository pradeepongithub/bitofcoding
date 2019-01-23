package codify;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.Map;
import org.junit.Test;
import com.codify.lemda.LamdaExpressionRunner;

public class LamdaExpressionRunnerTest {

  LamdaExpressionRunner runner = new LamdaExpressionRunner();

  @Test
  public void testCountOccurancesOfCountryCodes() {

    String[] countryCodes = {"JP", "IN", "CH", "IN", "HK", "JP", "IN"};

    Map<String, Long> expectedMap = Arrays.asList(countryCodes).stream().map(w -> w.split(","))
        .flatMap(Arrays::stream).collect(groupingBy(identity(), counting()));

    System.out.println(" testMap----> " + expectedMap);

    Map<String, Long> countryCountMap = runner.countOccurancesOfCountryCodes(countryCodes);

    assertThat(countryCountMap, is(expectedMap));

  }

  @Test
  public void testCountOccurancesOfChars() {

    String[] countryCodes = {"JP", "IN", "CH", "IN", "HK", "JP", "IN"};

    Map<String, Long> expectedMap = Arrays.asList(countryCodes).stream().map(w -> w.split(""))
        .flatMap(Arrays::stream).collect(groupingBy(identity(), counting()));

    System.out.println(" testMap----> " + expectedMap);

    Map<String, Long> countryCountMap = runner.countOccurancesOfChars(countryCodes);

    assertThat(countryCountMap, is(expectedMap));

  }

}
