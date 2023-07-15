package language_extensions;

import base_language.AbstractSyntaxElement;

import java.util.Optional;

public class LoopElement implements AbstractSyntaxElement {
    @Override
    public Optional<AbstractSyntaxElement> parse(String input) {
        return Optional.empty();
    }

    @Override
    public void interpret() {

    }
}
