package chapter._4four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * kudos @ https://gist.github.com/jaycobbcruz/cbabc1eb49f51bfe2ed1db10a06a2b26
 * This class creates a Stream towards a List of items of type <T>, and creates all the possible permutations of that
 * items.
 */
public class Util_Permutation {

        public static <T> Stream<Stream<T>> of(final List<T> items) {
            return IntStream.range(0, factorial(items.size())).mapToObj(i -> permutation(i, items).stream());
        }

        private static int factorial(final int num) {
            return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
        }

        private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
            if (input.isEmpty()) { return output; }

            final int factorial = factorial(input.size() - 1);
            output.add(input.remove(count / factorial));
            return permutation(count % factorial, input, output);
        }

        private static <T> List<T> permutation(final int count, final List<T> items) {
            return permutation(count, new LinkedList<>(items), new ArrayList<>());
        }


}
