package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class ReturnStatementElement implements AbstractSyntaxElement {
    @Override
    public ParseResult parse(String input) {
        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {
        return null;
    }
}
