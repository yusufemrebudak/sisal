package sisal.services.flightMs.util;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class NullPointerUtil {

    public static Boolean isNull(@NotNull Long objects) {
       return Objects.isNull(objects);
    }



}
