import base_language.AbstractSyntaxElement;
import base_language.ExpressionElement;

import java.util.Optional;

public class Main {
    private static final String code = """
            \\->{
                return 5
            }""";
    public static void main(String[] args) {

        Optional<AbstractSyntaxElement> asEl = new ExpressionElement().parse(code);
        asEl.ifPresent(AbstractSyntaxElement::interpret);

        System.out.println("Hello world!");
    }
}