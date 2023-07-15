package base_language;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public interface AbstractSyntaxElement {
    public Set<Supplier<AbstractSyntaxElement>> clauses = null;
    Optional<AbstractSyntaxElement> parse(String input);

    void interpret();
}
