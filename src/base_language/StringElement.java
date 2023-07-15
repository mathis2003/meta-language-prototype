package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class StringElement implements AbstractSyntaxElement {
    String value = null;
    @Override
    public ParseResult parse(String input) {
        if (input.charAt(0) == '\"') {
            input = input.substring(1);
            int endIndex = input.indexOf('\"');
            value = input.substring(0, endIndex);
            return new ParseResult(Optional.of(this), input.substring(endIndex + 1));
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {
        return value;

    }
}
