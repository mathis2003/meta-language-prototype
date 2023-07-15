package base_language;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ExpressionElement implements AbstractSyntaxElement {

    public Set<Supplier<AbstractSyntaxElement>> clauses = new HashSet<>(Arrays.asList(
            LambdaElement::new
    ));

    AbstractSyntaxElement parsedExpr = null;

    @Override
    public Optional<AbstractSyntaxElement> parse(String input) {

        for (Supplier<AbstractSyntaxElement> clause : clauses) {
            Optional<AbstractSyntaxElement> res = clause.get().parse(input);
            if (res.isPresent()) {
                parsedExpr = res.get();
                return res;
            }
        }

        return Optional.empty();
    }

    @Override
    public void interpret() {
        parsedExpr.interpret();
    }
}
