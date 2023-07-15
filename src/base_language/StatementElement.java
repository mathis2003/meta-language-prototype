package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class StatementElement implements AbstractSyntaxElement {
    AbstractSyntaxElement stmt;
    @Override
    public ParseResult parse(String input) {
        ParseResult res;

        if ((res = new ReturnStatementElement().parse(input)).parsedResult().isPresent()) {
            stmt = res.parsedResult().get();
            return new ParseResult(Optional.of(this), res.leftOverString());
        } else if ((res = new PrintStatementElement().parse(input)).parsedResult().isPresent()) {
            stmt = res.parsedResult().get();
            return new ParseResult(Optional.of(this), res.leftOverString());
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {

        return stmt.interpret();

    }
}
