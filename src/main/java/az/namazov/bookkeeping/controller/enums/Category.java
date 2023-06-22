package az.namazov.bookkeeping.controller.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import az.namazov.bookkeeping.controller.adapter.CategoryAdapter;
import az.namazov.bookkeeping.controller.parser.data.tinkoffData.TinkoffXlsRow;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Category implements CategoryAdapter {

    FOOD(List.of(Map.of("Категория", "Супермаркеты")));

    private final List<Map<String, String>> compareList;


    @Override
    public Category compare(TinkoffXlsRow row) {
        return Arrays.stream(values()).filter(category -> {
            String enumValue = category.compareList.get(0).get("Категория");
            if (enumValue != null && enumValue.equals(row.getCategory())) {
                return true;
            }
            return false;
        }).findFirst().get();
    }
}
