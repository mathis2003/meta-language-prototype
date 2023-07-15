package base_language;

import java.util.*;
import java.util.function.Supplier;

public class LambdaElement implements AbstractSyntaxElement {
    AbstractSyntaxElement body;
    @Override
    public Optional<AbstractSyntaxElement> parse(String input) {
        if (input.substring(0,3).equals("\\->")) {
            input = input.substring(3);
        } else return Optional.empty();

        Optional<AbstractSyntaxElement> res = new BodyElement().parse(input);
        if (res.isPresent()) {
            body = res.get();
            return res;
        }

        return Optional.empty();
    }

    @Override
    public void interpret() {
        body.interpret();
    }
}
