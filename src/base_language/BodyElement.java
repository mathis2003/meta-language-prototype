package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class BodyElement implements AbstractSyntaxElement{
    StatementElement stmt = null;
    @Override
    public ParseResult parse(String input) {
        if (input.charAt(0) == '{') {
            ParseResult res = new StatementElement().parse(input.substring(1));
            if (res.parsedResult().isPresent() && res.leftOverString().charAt(0) == '}') {
                stmt = (StatementElement) res.parsedResult().get();
                return new ParseResult(Optional.of(this), res.leftOverString().substring(1));
            }
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {

        return stmt.interpret();

    }
}
