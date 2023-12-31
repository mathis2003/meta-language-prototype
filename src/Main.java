import base_language.AbstractSyntaxElement;
import base_language.ExpressionElement;
import meta_lang.ParseResult;

import java.util.Optional;

public class Main {
    private static final String code = """
            \\->{
                for 1 to 5 {
                    print "hey"
                }
            }""";
    public static void main(String[] args) {

        ParseResult asEl = new ExpressionElement().parse(code.replaceAll("\\s+",""));

        if (asEl.parsedResult().isPresent()) {
            asEl.parsedResult().get().interpret();
        }
        //asEl.parsedResult().ifPresent(AbstractSyntaxElement::interpret);

        System.out.println("-----------");

        asEl = new ExpressionElement().parse("\"hey this is my string\"");
        if (asEl.parsedResult().isPresent()) {
            System.out.println(asEl.parsedResult().get().interpret());
        }
    }
}