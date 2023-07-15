import base_language.AbstractSyntaxElement;
import base_language.ExpressionElement;
import meta_lang.ParseResult;

import java.util.Optional;

public class Main {
    private static final String code = """
            \\->{
                print "5"
            }""";
    public static void main(String[] args) {

        ParseResult asEl = new ExpressionElement().parse(code.replaceAll("\\s+",""));

        if (asEl.parsedResult().isPresent()) {
            asEl.parsedResult().get().interpret();
        }
        //asEl.parsedResult().ifPresent(AbstractSyntaxElement::interpret);

        System.out.println("Hello world!");
    }
}