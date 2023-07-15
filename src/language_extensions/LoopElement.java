package language_extensions;

import base_language.AbstractSyntaxElement;
import base_language.BodyElement;
import base_language.IntElement;
import meta_lang.ParseResult;

import java.util.Optional;

public class LoopElement implements AbstractSyntaxElement {
    AbstractSyntaxElement start, end; // supposed to be an IntElement of course
    AbstractSyntaxElement body = null; // supposed to be a BodyElement of course
    @Override
    public ParseResult parse(String input) {
        String original_input = input;
        if (input.substring(0,3).equals("for")) {
            input = input.substring(3);
            ParseResult start_res = new IntElement().parse(input);
            if (start_res.parsedResult().isPresent()) {
                start = start_res.parsedResult().get();
                input = start_res.leftOverString();
                if (input.substring(0,2).equals("to")) {
                    input = input.substring(2);
                    ParseResult end_res = new IntElement().parse(input);
                    if (end_res.parsedResult().isPresent()) {
                        end = end_res.parsedResult().get();
                        input = end_res.leftOverString();
                        ParseResult bodyResult = new BodyElement().parse(input);
                        if (bodyResult.parsedResult().isPresent()) {
                            body = bodyResult.parsedResult().get();
                            input = bodyResult.leftOverString();
                            return new ParseResult(Optional.of(this), input);
                        }
                    }
                }

            }

        }
        return new ParseResult(Optional.empty(), original_input);
    }

    @Override
    public Object interpret() {
        int i = (Integer)start.interpret();
        int j = (Integer)end.interpret();
        for (;i <= j; i++) {
            body.interpret();
        }
        return null;
    }
}
