package com.codify.lemda;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LamdaExpressionRunner {
  

  public Map<String, Long> countOccurancesOfCountryCodes(String... countryCodes) {

    List<String> codeList = Arrays.asList(countryCodes);
    
    return codeList.stream().map(w -> w.split(",")).flatMap(Arrays::stream)
        .collect(groupingBy(identity(), counting()));

  }

  public Map<String, Long> countOccurancesOfChars(String... countryCodes) {

    List<String> codeList = Arrays.asList(countryCodes);

    return codeList.stream().map(w -> w.split("")).flatMap(Arrays::stream)
        .collect(groupingBy(identity(), counting()));

  }

}


