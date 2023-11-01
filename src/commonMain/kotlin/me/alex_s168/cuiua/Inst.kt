package me.alex_s168.cuiua

enum class Inst(
    val gylph: String,
    vararg val names: String
) {

    FUN_DECL("⟼", "fun", "declare"),

    MODULO("◿", "modulo"),
    COUNT("⍟", "count"),
    ALL("⁁", "all"),
    DUP2("˙", "2dup"),
    XOR("⊻", "xor"),
    AND("∧", "and"),
    OR("∨", "or"),
    ACCURACY("℀", "accuracy"),
    MAKE_FRACTION("⑀", "makefraction"),
    CAST_FRACTION("ℚ", "castfraction"),
    CAST_STRING("𝕐", "caststring"),
    CAST_REAL("ℝ", "castreal"),
    CAST_INTEGER("ℤ", "castinteger"),
    NEWLINE("↪", "newline", "nl"),
    READ_FILE("⇲", "readfile"),
    WRITE_FILE("⇱", "writefile"),
    FRAGMENT("⬡", "fragment"),
    DEARRAY("≡", "dearray"),
    BRACKET("⊓", "bracket"),
    GROUP("⊕", "group"),
    TABLE("⊞", "table"),
    SEPARATE("⍞", "separate"),
    SPLIT("◫", "split"),
    MIN("↧", "minimum"),
    MAX("↥", "maximum"),
    ASSERT("⍤", "assert"),
    GTE(">=", "gte", "greaterequal"),
    GT(">", "gt", "greater"),
    LTE("<=", "lte", "lessequal"),
    LT("<", "lt", "less"),
    NEQ("!=", "neq", "notequal"),
    EQ("=", "eq", "equal"),
    NEGATE("¯", "negate"),
    NOT("¬", "not"),
    NAN("♮", "nan"),
    FALSE("⊥", "false"),
    TRUE("⊤", "true"),
    FOLD("fold", "fold"),
    DISTRIBUTE("∺", "distribute"),
    COUPLE("⊟", "couple"),
    EXACT("⌖", "exact"),
    FIND("⌕", "find"),
    KEEP("▽", "keep"),
    DIP("⊙", "dip"),
    BOTH("∩", "both"),
    INF("∞", "inf"),
    RAND("⚂", "rand"),
    TAU("τ", "tau"),
    ETA("η", "eta"),
    PI("π", "pi"),
    TRACE("~", "trace"),
    SORT_DESC("⍖", "sortdesc"),
    SORT_ASC("⍏", "sortasc"),
    TRANSPOSE("⍉", "transpose"),
    ENUMERATE("⋯", "enumerate"),
    BOX("□", "box"),
    UNBOX("⊔", "unbox"),
    DEDUPLICATE("⊝", "deduplicate"),
    WHERE("⊚", "where"),
    RANGE("⇡", "range"),
    FIRST("⊢", "first"),
    LEN("⧻", "length"),
    TYPE("⚙", "typeof"),
    EMPTY_SET("∅", "emptyset"),
    RESHAPE("↯", "reshape"),
    REPEAT("⍥", "repeat"),
    SHAPE("△", "shape"),
    PUSH("∘", "push"),
    MEMBER("∊", "member"),
    INDEX_OF("⊗", "indexof"),
    PICK("⊡", "pick"),
    SELECT("⊏", "select"),
    JOIN("⊂", "join"),
    MATCH("≅", "match"),
    DESHAPE("♭", "deshape"),
    REVERSE("⇌", "reverse"),
    ROT("↻", "rot"),
    DROP("↘", "drop"),
    TAKE("↙", "take"),
    DIVIDE("÷", "divide"),
    MULTIPLY("×", "multiply"),
    ADD("+", "add"),
    SUBTRACT("-", "subtract"),
    EACH("∵", "each"),
    NOOP("∘", "noop", "nop"),
    FORK("⊃", "fork"),

    CALL("!", "call"),
    SWAP(":", "swap"),
    DUP(".", "duplicate"),
    OVER(",", "over"),
    REDUCE("/", "reduce"),
    SCAN("\\", "scan"),
    IF("?", "if"),


    ;

    companion object {

        /**
         * if any instruction starts with the given string, return it (UNLESS there are multiple matches)
         */
        fun fromName(name: String): Inst? {
            val matches = entries.filter { inst -> inst.names.any { it.startsWith(name) } }
            return if (matches.size == 1) matches[0] else null
        }

        /**
         * if any instruction starts with the start of the given string, return it (UNLESS there are multiple matches)
         * also returns the amount of characters that were matched
         * example: advancedFromName("minabc") returns (3, MIN)
         */
        fun advancedFromName(text: String): Pair<Int, Inst?> {
            var i = text.length - 1
            while (i >= 0) {
                val sub = text.substring(0, i + 1)
                val inst = fromName(sub)
                if (inst != null) {
                    return Pair(i + 1, inst)
                }
                i--
            }
            return Pair(0, null)
        }

    }
}