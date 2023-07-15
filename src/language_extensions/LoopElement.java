package language_extensions;

import base_language.AbstractSyntaxElement;
import meta_lang.ParseResult;

import java.util.Optional;

public class LoopElement implements AbstractSyntaxElement {
    @Override
    public ParseResult parse(String input) {
        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {

        return null;
    }
}
