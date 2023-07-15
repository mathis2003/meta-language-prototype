package meta_lang;

import base_language.AbstractSyntaxElement;

import java.util.Optional;

public record ParseResult(Optional<AbstractSyntaxElement> parsedResult, String leftOverString) {
}
