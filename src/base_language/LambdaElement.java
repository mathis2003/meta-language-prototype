package base_language;

import meta_lang.ParseResult;

import java.util.*;
import java.util.function.Supplier;

public class LambdaElement implements AbstractSyntaxElement {
    AbstractSyntaxElement body;
    @Override
    public ParseResult parse(String input) {
        if (input.substring(0,3).equals("\\->")) {
            input = input.substring(3);
        } else return new ParseResult(Optional.empty(), input);

        ParseResult res = new BodyElement().parse(input);
        if (res.parsedResult().isPresent()) {
            body = res.parsedResult().get();
            return new ParseResult(Optional.of(this), res.leftOverString());
        }

        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {
        return body.interpret();
    }
}
