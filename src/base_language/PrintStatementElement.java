package base_language;

import meta_lang.ParseResult;

import java.util.Optional;

public class PrintStatementElement implements AbstractSyntaxElement {
    AbstractSyntaxElement printString = null;

    @Override
    public ParseResult parse(String input) {
        if (input.substring(0, 5).equals("print")) {
            ParseResult res = new StringElement().parse(input.substring(5));
            if (res.parsedResult().isPresent()) {
                printString = res.parsedResult().get();
                return new ParseResult(Optional.of(this), res.leftOverString());
            }
        }
        return new ParseResult(Optional.empty(), input);
    }

    @Override
    public Object interpret() {
        System.out.println(printString.interpret());
        return null;
    }
}
