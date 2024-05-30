package site.lawmate.lawcase.common.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
      public static Function<Integer, Integer> absInt = Math::abs;

    //Math.ceil
    public static Function<Double, Double> ceil = Math::ceil;
    //Math.floor
    public static Function<Double, Double> floor = Math::floor;
    //Math.round
//    public static
    //Math.min

    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;

    public static Supplier<Double> randomDouble = Math::random;

    public static BiFunction<Integer,Integer,Integer> randomInt = (a, b) -> (int)(Math.random() * (b-a) + a);

    //Integer.parseInt
}
