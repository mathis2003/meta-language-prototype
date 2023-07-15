package base_language;

import meta_lang.ParseResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class StatementElement implements AbstractSyntaxElement {
    AbstractSyntaxElement stmt;

    public Set<Supplier<AbstractSyntaxElement>> clauses = new HashSet<>(Arrays.asList(
            ReturnStatementElement::new,
            PrintStatementElement::new
    ));
    @Override
    public ParseResult parse(String input) {
        ParseResult res;

        for (Supplier<AbstractSyntaxElement> clause : clauses) {
            if ((res = clause.get().parse(input)).parsedResult().isPresent()) {
                stmt = res.parsedResult().get();
                return new ParseResult(Optional.of(this), res.leftOverString());
            }
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {

        return stmt.interpret();

    }
}
