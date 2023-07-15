package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class IntElement implements AbstractSyntaxElement {
    int value = 0;
    @Override
    public ParseResult parse(String input) {
        int i = 0;
        int j = input.charAt(0) - '0';
        if (j < 0 || 9 < j) return new ParseResult(Optional.empty(), input);

        value += j;
        for (i=1;;i++) {
            j = input.charAt(i) - '0';
            if (0 < j && j < 9) {
                value *= 10;
                value += j;
            } else return new ParseResult(Optional.of(this), input.substring(i));
        }
    }

    @Override
    public Object interpret() {
        return value;
    }
}
