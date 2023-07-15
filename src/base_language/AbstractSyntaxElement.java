package base_language;

import meta_lang.ParseResult;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public interface AbstractSyntaxElement {
    public Set<Supplier<AbstractSyntaxElement>> clauses = null;
    ParseResult parse(String input);

    Object interpret();
}
