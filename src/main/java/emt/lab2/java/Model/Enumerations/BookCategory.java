package emt.lab2.java.Model.Enumerations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BookCategory {
    NOVEL,
    THRILER,
    HISTORY,
    FANTASY,
    BIOGRAPHY,
    CLASSICS,
    DRAMA;

    public static List<BookCategory> allCategories(){
        return Stream.of(BookCategory.values()).collect(Collectors.toList());
    }
}
