package base_language;

import java.util.Optional;

public class BodyElement implements AbstractSyntaxElement{
    @Override
    public Optional<AbstractSyntaxElement> parse(String input) {
        return Optional.empty();
    }

    @Override
    public void interpret() {

    }
}
