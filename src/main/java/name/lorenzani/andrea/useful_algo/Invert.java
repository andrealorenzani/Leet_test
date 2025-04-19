package name.lorenzani.andrea.useful_algo;

import java.util.Collection;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

public class Invert<T> {

    public Collection<T> invert(Collection<T> input) {
        Stack<T> inverter = new Stack<>();
        inverter.addAll(input);
        input.clear();
        while(!inverter.empty()) {
            input.add(inverter.pop());
        }
        return input;
    }

    public String invert(String input) {
        StringBuilder builder = new StringBuilder();
        for(int i=input.length()-1; i>=0; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString();
    }
}
