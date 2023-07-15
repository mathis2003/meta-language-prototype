package base_language;

import meta_lang.ParseResult;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ExpressionElement implements AbstractSyntaxElement {

    public Set<Supplier<AbstractSyntaxElement>> clauses = new HashSet<>(Arrays.asList(
            LambdaElement::new,
            StringElement::new,
            IntElement::new
    ));

    AbstractSyntaxElement parsedExpr = null;

    @Override
    public ParseResult parse(String input) {

        for (Supplier<AbstractSyntaxElement> clause : clauses) {
            ParseResult res = clause.get().parse(input);
            if (res.parsedResult().isPresent()) {
                parsedExpr = res.parsedResult().get();
                return new ParseResult(Optional.of(this), res.leftOverString());
            }
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {
        return parsedExpr.interpret();
    }
}
