package com.github.blalasaadri.javaNextDemos.java11.lambdavar;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaVar {

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    private static BiFunction<List<String>, Integer, String> joinListNTimes =
            (@Nonnull var list, @Nonnegative var times) ->
                    repeatElementNTimes(list, times)
                            .map(words -> String.join(" ", words))
                            .collect(Collectors.joining("\n"));

    public void repeat3times(String... args) {
        System.out.println(joinListNTimes.apply(Arrays.asList(args), 3));
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    private static <T> Stream<T> repeatElementNTimes(T element, int times) {
        return IntStream.range(0, times)
                .mapToObj(i -> element);
    }
}
