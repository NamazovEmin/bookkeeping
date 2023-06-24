package az.namazov.bookkeeping.controller.enums;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    FOOD(Map.of("Тиньков", List.of(TinkoffCategory.SUPER_MARKET.name()),
                "Банк Развитие", List.of("sds"),
                "Альфа-Банк", List.of("sdsd")));

    private final Map<String, List<String>> compareList;


}
